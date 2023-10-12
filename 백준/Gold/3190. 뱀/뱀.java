import java.io.*;
import java.util.*;

public class Main {
    static int N, K, L;
    static StringTokenizer st;
    static BufferedReader br;
    static boolean[][] Map;
    static int[] orderTime;
    static char[] orderDir;
    static ArrayDeque<Cord> snake;

    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();

        int answer = 0;

        // 우->상->좌->하 : L 기준 ++, D 기준 --
        int[] move_i = {0, -1, 0, 1};
        int[] move_j = {1, 0, -1, 0};
        int next_i, next_j;
        int dir = 0; // 현재 바라보는 방향: 우측
        
        snake = new ArrayDeque<>();
        snake.add(new Cord(0, 0));
        int time = 0; // 게임 시작 후 경과 시간
        while(true) {
            next_i = move_i[dir] + snake.peek().i;
            next_j = move_j[dir] + snake.peek().j;
            
            // 벽에 부딪힌 경우 : 종료
            if(isMapEnd(next_i, next_j)) {
                answer = time+1;
                break;
            }
            // 자신의 몸에 부딪힌 경우 : 종료
            if(isBody(next_i, next_j)) {
                answer = time+1;
                break;
            }

            // 조건에 따라 꼬리 움직이기
            if(Map[next_i][next_j]) { // 사과 있는 경우
                snake.addFirst(new Cord(next_i, next_j));
                Map[next_i][next_j] = false;
            } else {
                snake.addFirst(new Cord(next_i, next_j));
                snake.pollLast();
            }

            time++;

            for(int i=0; i<orderTime.length; i++) {
                if(orderTime[i] == time) {
                    if(orderDir[i] == 'D') {
                        if(dir == 0) dir = 3;
                        else dir--;
                    } else if (orderDir[i] == 'L') {
                        if(dir == 3) dir = 0;
                        else dir++;
                    }
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        
    }

    static boolean isMapEnd(int next_i, int next_j) {
        if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= N) return true;
        return false;
    }

    static boolean isBody(int next_i, int next_j) {
        for(Cord cord : snake) {
            if(cord.i == next_i && cord.j == next_j) {
                return true;
            }
        }
        return false;
    }

    static class Cord {
        int i, j;
        public Cord (int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static void getInput() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        Map = new boolean[N][N];
        for(int i=0; i<K; i++) { // 사과 있는 좌표는 true, 나머진 false
            st = new StringTokenizer(br.readLine());
            Map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
        }

        L = Integer.parseInt(br.readLine());
        orderTime = new int[L];
        orderDir = new char[L];
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            orderTime[i] = Integer.parseInt(st.nextToken());
            orderDir[i] = st.nextToken().charAt(0);
        }
    }
}

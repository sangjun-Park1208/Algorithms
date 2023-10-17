import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, next_i, next_j, answer;
    static int[] move_i = {-1, 1, 0, 0};
    static int[] move_j = {0, 0, -1, 1};
    static int[][] Map;
    static boolean[][] isVisit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();
        bfs();
        bw.write(String.valueOf(answer));
        bw.flush();
        return;
    }

    static void bfs() {
        ArrayDeque<Cord> queue = new ArrayDeque<>();
        Cord cord;
        queue.add(new Cord(0, 0, 1));
        answer = 10000;
        isVisit = new boolean[N][M];
        isVisit[0][0] = true;

        while(!queue.isEmpty()) {
            cord = queue.poll();
            if(cord.i == N-1 && cord.j == M-1) {
                answer = cord.dist;
                break;
            }
            for(int k=0; k<4; k++) {
                next_i = cord.i + move_i[k];
                next_j = cord.j + move_j[k];
                
                if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= M) continue;

                if(!isVisit[next_i][next_j] && Map[next_i][next_j] == 1) {
                    isVisit[next_i][next_j] = true;
                    queue.add(new Cord(next_i, next_j, cord.dist+1));
                }
            }
        }

    }

    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String input;
        Map = new int[N][M];
        for(int i=0; i<N; i++) {
            input = br.readLine();
            for(int j=0; j<input.length(); j++) {
                Map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }
    }

    static class Cord {
        int i, j, dist;
        public Cord(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

}
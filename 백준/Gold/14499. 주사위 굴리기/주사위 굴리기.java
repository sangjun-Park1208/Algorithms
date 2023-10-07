import java.io.*;
import java.util.*;

public class Main {
    static int N, M, si, sj, K;
    static StringTokenizer st;
    static BufferedReader br;
    static int[][] Map;
    static int[] orders;
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();

        int[] move_i = {-1, 1, 0, 0};
        int[] move_j = {0, 0, -1, 1};
        int next_i, next_j;
        int[] cube = {0, 0, 0, 0, 0, 0};
        int up = 0; // 위쪽을 바라보는 주사위 면 인덱스
        int north = 1; // 북쪽을 바라보는 주사위 면 인덱스
        int east = 2; // 동쪽을 바라보는 주사위 면 인덱스
        int tmp;

        for(int i=0; i<K; i++) {
            if(orders[i] == 1) { // 동쪽
                next_i = move_i[3] + si;
                next_j = move_j[3] + sj;
                if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= M) continue;

                tmp = up;
                up = 5 - east;
                east = tmp;

                if(Map[next_i][next_j] > 0) {
                    cube[5-up] = Map[next_i][next_j];
                    Map[next_i][next_j] = 0;
                } 
                else if(Map[next_i][next_j] == 0) {
                    Map[next_i][next_j] = cube[5-up];
                }
                si = next_i;
                sj = next_j;

            }
            else if(orders[i] == 2) { // 서쪽
                next_i = move_i[2] + si;
                next_j = move_j[2] + sj;
                if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= M) continue;

                tmp = east;
                east = 5 - up;
                up = tmp;

                if(Map[next_i][next_j] > 0) {
                    cube[5-up] = Map[next_i][next_j];
                    Map[next_i][next_j] = 0;
                } 
                else if(Map[next_i][next_j] == 0) {
                    Map[next_i][next_j] = cube[5-up];
                }
                si = next_i;
                sj = next_j;
            }
            else if(orders[i] == 3) { // 북쪽
                next_i = move_i[0] + si;
                next_j = move_j[0] + sj;
                if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= M) continue;

                tmp = up;
                up = 5 - north;
                north = tmp;

                if(Map[next_i][next_j] > 0) {
                    cube[5-up] = Map[next_i][next_j];
                    Map[next_i][next_j] = 0;
                } 
                else if(Map[next_i][next_j] == 0) {
                    Map[next_i][next_j] = cube[5-up];
                }
                si = next_i;
                sj = next_j;
            }
            else if(orders[i] == 4) { // 남쪽
                next_i = move_i[1] + si;
                next_j = move_j[1] + sj;
                if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= M) continue;

                tmp = north;
                north = 5 - up;
                up = tmp;

                if(Map[next_i][next_j] > 0) {
                    cube[5-up] = Map[next_i][next_j];
                    Map[next_i][next_j] = 0;
                } 
                else if(Map[next_i][next_j] == 0) {
                    Map[next_i][next_j] = cube[5-up];
                }
                si = next_i;
                sj = next_j;
            }

            bw.write(String.valueOf(cube[up]) + "\n");
        }

        bw.flush();
    }

    static void getInput() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        si = Integer.parseInt(st.nextToken());
        sj = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        orders = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, H;
    static int[][][] Boxes;
    static int[] move_h = {0, 0, 0, 0, -1, 1};
    static int[] move_i = {-1, 1, 0, 0, 0, 0};
    static int[] move_j = {0, 0, -1, 1, 0, 0};
    static boolean[][][] isVisit;
    static int next_h, next_i, next_j;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();
        int answer = bfs();
        bw.write(String.valueOf(answer));
        bw.flush();
        return;
    }

    static int bfs() {
        int day = 0;
        int ripe = 0;
        int empty = 0;
        
        ArrayDeque<Cord> queue = new ArrayDeque<>();
        Cord cord;
        for(int h=0; h<H; h++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++){
                    if(Boxes[h][i][j] == 1) {
                        queue.add(new Cord(h, i, j));
                        isVisit[h][i][j] = true;
                        ripe++;
                    } else if(Boxes[h][i][j] == -1) empty++;
                }
            }
        }
        int boxSize = H*N*M - empty;
        if(ripe == boxSize) return 0;
        
        int size;
        while(!queue.isEmpty()) {
            size = queue.size();
            if(ripe == boxSize) return day;
            day++;
            for(int cnt=0; cnt<size; cnt++) {
                if(ripe == boxSize) return day;
                cord = queue.poll();
                for(int k=0; k<6; k++) {
                    next_h = move_h[k] + cord.h;
                    next_i = move_i[k] + cord.i;
                    next_j = move_j[k] + cord.j;
    
                    if(next_h < 0 || next_i < 0 || next_j < 0 || next_h >= H || next_i >= N || next_j >= M) continue;

                    if(Boxes[next_h][next_i][next_j] == -1 || Boxes[next_h][next_i][next_j] == 1) continue;
    
                    if(!isVisit[next_h][next_i][next_j]) {
                        isVisit[next_h][next_i][next_j] = true;
                        ripe++;
                        queue.add(new Cord(next_h, next_i, next_j));
                    }
                }
            }
            
        }
        
        return -1;
    }

    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        Boxes = new int[H][N][M];
        isVisit = new boolean[H][N][M];
        for(int h=0; h<H; h++) {
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++) {
                    Boxes[h][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    static class Cord {
        int h, i, j;
        public Cord(int h, int i, int j) {
            this.h = h;
            this.i = i;
            this.j = j;
        }
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, ans, cnt;
    static StringTokenizer st;
    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] Map, DP;
    static boolean[][] Visit;
    static int[] move_i = {-1, 1, 0, 0};
    static int[] move_j = {0, 0, -1, 1};
    static Queue<Pair> Q;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solve();
        bw.flush();
    }

    static void Solve() throws IOException{
        cnt = 0;
        while(true){
            cnt++;
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            Map = new int[N+1][N+1];
            DP = new int[N+1][N+1];
            Visit = new boolean[N+1][N+1];

            /* Input */
            for(int i=1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=N; j++) Map[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<=N; i++) {
                Arrays.fill(DP[i], 987654321);               
            }

            /* Solve */
            Q = new LinkedList<>();
            Q.add(new Pair(1, 1));
            DP[1][1] = Map[1][1];
            Pair p;
            while(!Q.isEmpty()){
                p = Q.poll();
                if(p.i == N && p.j == N) continue;
                int next_i, next_j;
                for(int k=0; k<4; k++){
                    next_i = p.i + move_i[k];
                    next_j = p.j + move_j[k];
                    
                    if(next_i <= 0 || next_j <= 0 || next_i > N || next_j > N) continue;

                    if(DP[p.i][p.j] + Map[next_i][next_j] < DP[next_i][next_j]){
                        DP[next_i][next_j] = DP[p.i][p.j] + Map[next_i][next_j];
                        Q.add(new Pair(next_i, next_j));
                    }                    
                }
            }
            bw.write("Problem " + cnt + ": " + DP[N][N] + "\n");
            
        }
    }

    static class Pair{
        int i, j;
        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    static void printDP() {
        System.out.println("DP : ");
        for(int i=0; i<=N; i++){
            for(int j=0; j<=N; j++) System.out.print(DP[i][j] + " ");
            System.out.println();
        }
    }
}
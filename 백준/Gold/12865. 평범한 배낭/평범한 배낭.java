import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, K;
    static int[][] input, DP;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));

        getInput();
        Solve();
    }

    static void Solve() throws IOException{
        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(j < input[i][0]){
                    DP[i][j] = DP[i-1][j];
                    continue;
                }
                DP[i][j] = Math.max(DP[i-1][j-input[i][0]] + input[i][1], DP[i-1][j]);
            }
        }
        System.out.println(DP[N][K]);
    }
    
    static void getInput() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        input = new int[N+1][2];
        DP = new int[N+1][K+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void print() {
        System.out.println("DP :");
        for(int i=0; i<=N; i++){
            for(int j=0; j<=K; j++) System.out.print(DP[i][j] + " ");
            System.out.println();
        }
    }
}
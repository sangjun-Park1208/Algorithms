import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] p = new int[N+1]; // 0 ~ N
        p[0] = input[0][0];
        for(int i=1; i<=N; i++){ p[i] = input[i-1][1]; }

        int[][] DP = new int[N+1][N+1];
        for(int len=1; len<=N; len++){ // 우하향 대각선
            for(int i=1; i<=N-len; i++){
                int j = i + len;
                DP[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    DP[i][j] = Math.min(DP[i][j], DP[i][k] + DP[k+1][j] + p[i-1]*p[k]*p[j]);
                }
            }
        }
        bw.write(String.valueOf(DP[1][N]));
        bw.flush();

    }
}

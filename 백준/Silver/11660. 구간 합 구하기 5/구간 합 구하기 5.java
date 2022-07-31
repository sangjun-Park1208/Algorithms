import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] cdn; // 좌표 : coordinate
    static int[][] dp; // dp table
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];

        for(int i=1; i<=N; i++){ // N x N 입력
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){ map[i][j] = Integer.parseInt(st.nextToken()); }
        }

        cdn = new int[M+1][4];
        for(int i=1; i<=M; i++){ // (x1, y1), (x2, y2) : M회 입력
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++) { cdn[i][j] = Integer.parseInt(st.nextToken());}
        }

        dp = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
            }
        }
        
        int ans;
        for(int i=1; i<=M; i++){
            ans = dp[cdn[i][2]][cdn[i][3]] - dp[cdn[i][0]-1][cdn[i][3]] - dp[cdn[i][2]][cdn[i][1]-1] + dp[cdn[i][0]-1][cdn[i][1]-1];
            bw.write(String.valueOf(ans + "\n"));
            bw.flush();
        }

    }
}

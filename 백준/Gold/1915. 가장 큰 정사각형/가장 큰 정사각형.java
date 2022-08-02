import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        String str;

        int[][] MAP = new int[M+1][N+1];
        for(int i=1; i<=M; i++){
            str = new String(br.readLine());
            for(int j=1; j<=N; j++){MAP[i][j] = str.charAt(j-1)-'0';}
        }

        int[][] DP = new int[M+1][N+1];
        int max = 0;
        for(int i=1; i<=M; i++){
            for(int j=1; j<=N; j++){
                if(MAP[i][j] == 0) continue;
                DP[i][j] = Math.min(Math.min(DP[i-1][j], DP[i][j-1]), DP[i-1][j-1]) + 1;
                if(max < DP[i][j]) max = DP[i][j];
            }
        }
        bw.write(String.valueOf(max*max));
        bw.flush();
    }
}

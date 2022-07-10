import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1535 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] L = new int[N+1];
        int[] J = new int[N+1];
        int[][] DP = new int[N+1][101];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        for(int i=1; i<=N; i++){
            L[i] = Integer.parseInt(st1.nextToken());
            J[i] = Integer.parseInt(st2.nextToken());
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=99; j++){
                if(L[i] <= j){
                    DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j-L[i]]+J[i]);
                }
                else{
                    DP[i][j] = DP[i-1][j];
                }
            }
        }

        bw.write(String.valueOf(DP[N][99]));
        bw.flush();
    }
 
}

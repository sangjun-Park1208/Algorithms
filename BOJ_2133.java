import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2133 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        if(N%2 != 0){
            bw.write(String.valueOf(0));
            bw.flush();
            return;
        }

        int[] dp = new int[N+1];
        
        dp[0] = 1;
        for(int i=2; i<=N; i+=2){
            dp[i] += dp[i-2]*3;
            for(int j=4; j<=i; j+=2){
                dp[i] += dp[i-j]*2;
            }
        }
        bw.write(String.valueOf(dp[N]));
        bw.flush();

    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2193 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // long[] DP = new long[92];

        // DP[1] = 1;
        // DP[2] = 1;
        // for(int i=3; i<=N; i++){
        //     DP[i] = DP[i-1] + DP[i-2];
        // }

        // dp(N);

        long[] DP = new long[92];
        for(int i=0; i<N; i++){DP[i] = -1;}

        bw.write(String.valueOf(dp(N, DP)));
        // bw.write(String.valueOf(DP[N]));
        bw.flush();
    }

    private static long dp(int a, long[] DP){
        if(a<=2) return 1;

        if(DP[a] == -1){
            return DP[a];
        }
        long sum = 0;
        sum += dp(a-1, DP) + dp(a-2, DP);
        DP[a] = sum;
        return sum;
    }
}

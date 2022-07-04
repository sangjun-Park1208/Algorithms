import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11726 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] DP = new int[1001];
        DP[0] = DP[1] = 1;
        for(int i=2; i<=n; i++){
            DP[i] = (DP[i-1] + DP[i-2]) % 10007;
        }
        bw.write(String.valueOf(DP[n]));
        bw.flush();
    }
}
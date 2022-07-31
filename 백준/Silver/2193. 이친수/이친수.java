import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] DP = new long[92];
        DP[1] = 1;
        DP[2] = 1;
        for(int i=3; i<=N; i++){
            DP[i] = DP[i-1] + DP[i-2];
        }
        bw.write(String.valueOf(DP[N]));
        bw.flush();
    }
}
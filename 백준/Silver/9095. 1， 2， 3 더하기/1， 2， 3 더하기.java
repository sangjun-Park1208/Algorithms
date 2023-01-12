import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int T;
    static int[] input, DP;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve() throws IOException {
        for(int t=1; t<=T; t++){
            DP = new int[input[t]+3];
            DP[1] = 1; DP[2] = 2; DP[3] = 4;
            for(int i=4; i<=input[t]; i++)
                DP[i] = DP[i-3] + DP[i-2] + DP[i-1];
            System.out.println(DP[input[t]]);
        }
    }

    static void getInput() throws IOException {
        T = Integer.parseInt(br.readLine());
        input = new int[T+1];
        for(int i=1; i<=T; i++) input[i] = Integer.parseInt(br.readLine());
    }
}
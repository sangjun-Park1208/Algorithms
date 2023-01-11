import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] DP;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve() {
        for(int i=4; i<=N; i++){
            DP[i] = DP[i-1]+1;
            
            if(i%3 == 0)
                DP[i] = Math.min(DP[i/3]+1, DP[i]);
            
            if(i%2 == 0)
                DP[i] = Math.min(DP[i/2]+1, DP[i]);
            
        }
        System.out.print(DP[N]);
    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        DP = new int[N+3];
        DP[1] = 0;
        DP[2] = DP[3] = 1;
    }
}
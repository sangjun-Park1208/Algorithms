import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, ans;
    static int[] input, DP;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve() {
        ans = -987654321;
        for(int i=1; i<=N; i++){
            DP[i] = Math.max(DP[i-1] + input[i], input[i]);
            ans = Math.max(ans, DP[i]);
        }
        System.out.println(ans);
    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        input = new int[N+1];
        DP = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) input[i] = Integer.parseInt(st.nextToken());
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, K, ans;
    static int[] input, sum;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        input = new int[N];
        sum = new int[N+1];
        ans = -201;

        getInput();
        Solve();
    }

    static void Solve() {
        /* 누적합 */
        int accSum = 0;
        sum[0] = 0;
        for(int i=0; i<N; i++){
            accSum += input[i];
            sum[i+1] = accSum;
        }

        if(N == K){
            System.out.println(sum[N]);
            return;
        }

        for(int i=0; i<=N-K; i++) 
            ans = Math.max(sum[i+K] - sum[i], ans);
        
        System.out.println(ans);
    }

    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<input.length; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
    }
}
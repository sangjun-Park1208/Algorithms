import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, K, maxSum, accm; // 추 개수(N), 확인하고자 하는 구슬 개수(K), 최대합(maxSum), 행 별 누적합(accm)
    static int diff;
    static int[] W, C; // 추의 무게들(W), 확인하고자 하는 구슬 무게들(C)
    static boolean[][] ans;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();
        Solve();
    }

    static void Solve() throws IOException {
        accm = 0;
        for(int i=1; i<=N; i++){
            accm += W[i];
            diff = W[i] - W[i-1];
            for(int j=1; j<=maxSum; j++){
                if(j == W[i] || j == maxSum) {
                    ans[i][j] = true;
                    continue;
                }

                if(j > accm) break; // i행 추까지의 누적합보다 크면 무조건 false

                if(ans[i-1][j]) { // 이전 행에서 이미 만들 수 있는 경우, 무조건 true
                    ans[i][j] = true;
                    continue;
                }

                if(j == diff) { // 바로 이전의 추 무게 차이
                    ans[i][j] = true;
                    continue;
                }

                if(ans[i-1][Math.abs(j-W[i])]) {
                    ans[i][j] = true;
                    continue;
                }

                if(j+W[i] <= maxSum && ans[i-1][j+W[i]]){
                    ans[i][j] = true;
                    continue;
                }

                ans[i][j] = ans[i-1][j];

            }
        }
        
        for(int i=0; i<K; i++){
            if(C[i] > maxSum) {
                bw.write("N" + " ");
                continue;
            }
            if(ans[N][C[i]]) bw.write("Y" + " ");
            else bw.write("N" + " ");
        }
        bw.flush();
    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        W = new int[N+1];
        st = new StringTokenizer(br.readLine());
        maxSum = 0;
        for(int i=1; i<=N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
            maxSum += W[i];
        }
        
        K = Integer.parseInt(br.readLine());
        C = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) C[i] = Integer.parseInt(st.nextToken());
        ans = new boolean[N+1][maxSum+1];
    }
}
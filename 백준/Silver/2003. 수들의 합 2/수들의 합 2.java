import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, ans;
    static int[] Map;
    static int[][] input;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve() {
        /* 누적합 */
        int tmp = 0;
        for(int i=1; i<=N; i++){
            tmp += Map[i];
            Map[i] = tmp;
        }

        /* 투 포인터 */
        int left = 0; 
        int right = 1;
        ans = 0;
        while(right <= N){
            if(Map[right] - Map[left] < M){
                right++;
                continue;
            }
            if(Map[right] - Map[left] == M) {
                ans++;
                right++;
                continue;
            }
            left++;
        }
        System.out.println(ans);
    }

    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map = new int[N+1];
        for(int i=1; i<=N; i++) Map[i] = Integer.parseInt(st.nextToken());
    }
}
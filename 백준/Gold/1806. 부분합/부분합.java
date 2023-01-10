import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, S, ans;
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
        int len = N+1;
        int left = 0; 
        int right = 1;
        if(Map[N] - Map[0] < S) {
            System.out.println(0);
            return;
        }
        while(right <= N){
            if(Map[right] - Map[left] >= S){
                len = Math.min(right - left, len);
                left++;
                continue;
            }
            right++;
        }
        System.out.println(len);
    }

    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map = new int[N+1];
        for(int i=1; i<=N; i++) Map[i] = Integer.parseInt(st.nextToken());
    }
}
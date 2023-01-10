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
    static int N, M, ans;
    static int[] Map;
    static int[][] input;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();
        Solve();
    }

    static void Solve() throws IOException {
        // 누적합
        int tmp = 0;
        for(int i=1; i<=N; i++){
            tmp += Map[i];
            Map[i] = tmp;
        }
        
        // 누적합 계산 : M회
        for(int i=0; i<M; i++){
            ans = Map[input[i][1]] - Map[input[i][0]-1];
            bw.write(ans + "\n");
        }
        bw.flush();
    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Map = new int[N+1];
        for(int i=1; i<=N; i++) Map[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        input = new int[M][2];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}
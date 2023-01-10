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
    static int N, M, K, ans;
    static int[][] Map, input;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();
        Solve();
    }

    static void Solve() throws IOException {
        // 행 누적합
        int tmp;
        for(int i=0; i<=N; i++){
            tmp = 0;
            for(int j=0; j<=M; j++){
                tmp += Map[i][j];
                Map[i][j] = tmp; 
            }
        }

        // 열 누적합
        for(int j=0; j<=M; j++){
            tmp = 0;
            for(int i=0; i<=N; i++){
                tmp += Map[i][j];
                Map[i][j] = tmp;
            }
        }

        // 누적합 계산 : K회
        for(int k=0; k<K; k++){
            ans = Map[input[k][2]][input[k][3]] - Map[input[k][0]-1][input[k][3]] -Map[input[k][2]][input[k][1]-1] + Map[input[k][0]-1][input[k][1]-1];
            bw.write(ans + "\n");
        }
        bw.flush();
    }

    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) Map[i][j] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());
        input = new int[K][4];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++) input[i][j] = Integer.parseInt(st.nextToken());
        }

    }
}
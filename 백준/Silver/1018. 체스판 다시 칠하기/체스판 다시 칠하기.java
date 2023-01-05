import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static String[] input;
    static int[][] Map;
    static int ans;

    /* B_map : B(0)로 시작, W_map : W(1)로 시작 */
    static int[][] B_map, W_map; 

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B_map = new int[8][8];
        W_map = new int[8][8];
        input = new String[N];
        Map = new int[N][M];
        ans = 32;
        
        init_BWmap();
        getInput();

        Solve();
    }

    static void Solve() {
        for(int i=0; i<=N-8; i++)
            for(int j=0; j<=M-8; j++)
                ans = Math.min(ans, compareMap(i, j));
        
        System.out.println(ans);
    }

    static int compareMap(int a, int b) {
        int ret1 = 0;
        int ret2 = 0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(Map[a+i][b+j] == B_map[i][j]) ret1++;
                if(Map[a+i][b+j] == W_map[i][j]) ret2++;
            }
        }
        return Math.min(ret1, ret2);
    }

    /* Map input --> 0, 1로 매핑 */
    static void getInput() throws IOException {
        for(int i=0; i<N; i++){
            input[i] = br.readLine();
            for(int j=0; j<M; j++){
                if(input[i].charAt(j) == 'B'){
                    Map[i][j] = 0;
                    continue;
                }
                Map[i][j] = 1;
            }
        }
    }

    /* B_map, W_map 초기화*/
    static void init_BWmap() {
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(i%2 == 0){
                    B_map[i][j] = j%2;
                    W_map[i][j] = (j+1)%2;
                    continue;
                }
                B_map[i][j] = (j+1)%2;
                W_map[i][j] = j%2;
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, tmp1, tmp2, ans;
    static int[][] Map;
    static boolean[] visit;
    static int[] selected, unselected;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve(1, 0);
        System.out.println(ans);
    }

    static void Solve(int start, int depth) {
        if(depth == N/2){
            int k = 0; int s = 0;
            for(int i=1; i<=N; i++){
                if(visit[i]){
                    selected[k++] = i;
                    continue;
                }
                unselected[s++] = i;
            }
                
            tmp1 = tmp2 = 0;
            for(int i=0; i<N/2; i++)
                for(int j=i+1; j<N/2; j++) {
                    tmp1 += Map[selected[i]][selected[j]] + Map[selected[j]][selected[i]];
                    tmp2 += Map[unselected[i]][unselected[j]] + Map[unselected[j]][unselected[i]];
                }
                
            ans = Math.min(ans, Math.abs(tmp1 - tmp2));
            return;
        }

        for(int i=start; i<=N; i++){
            if(visit[i]) continue;
            visit[i] = true;
            Solve(i+1, depth+1);
            visit[i] = false;
        }

    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        Map = new int[N+1][N+1];
        visit = new boolean[N+1];
        selected = new int[N/2];
        unselected = new int[N/2];
        ans = 987654321;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
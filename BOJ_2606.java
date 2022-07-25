import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2606 {
    private static int[][] input;
    static int N;
    static int[] C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        input = new int[N+1][N+1];
        C = new int[N+1];
        
        StringTokenizer st;

        int f, t;
        for(int i=0; i<K; i++) { // 마킹
            st = new StringTokenizer(br.readLine());
            f = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            if(input[f][t] == 0 && input[t][f] == 0){
                input[f][t]=1;
                input[t][f]=1;

            }
        }
        C[1] = 1;
        int ans = dfs(1);
        bw.write(String.valueOf(ans));
        bw.flush();
    }
    private static int dfs(int row){
        int sum = 0;
        int cnt = 0;
        for(int i=1; i<=N; i++){
            if(input[row][i] == 1 && C[i] == 0){
                cnt++;
                C[i] = 1;
                sum += dfs(i);        
            }
        }
        return sum += cnt;
    }

}

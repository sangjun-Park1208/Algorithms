import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] input = new int[N+1][N+1];
        int[][] D = new int[N+1][N+1];
        StringTokenizer st;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                D[i][j] = Math.max(D[i-1][j-1], D[i-1][j]) + input[i][j];
            }
        }
        
        int max = 0;
        for(int j=1; j<=N; j++){
            if(max <= D[N][j])
                max = D[N][j];
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
}

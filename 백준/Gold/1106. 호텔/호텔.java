import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] d = new int[N+1][2];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            d[i][0] = Integer.parseInt(st.nextToken());
            d[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] DP = new int[100001];
        for(int i=1; i<=N; i++){
            for(int j=d[i][0]; j<=100000; j++){
                DP[j] = Math.max(DP[j], DP[j-d[i][0]]+d[i][1]);
            }
        }
        for(int i=1; i<=100000; i++){
            if(DP[i]>=C){
                bw.write(String.valueOf(i));
                bw.flush();
                break;
            }
        }

    }
}

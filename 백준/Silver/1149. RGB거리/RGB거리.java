import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] MAP = new int[N][3];
        int[][] DP = new int[N][3];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){ MAP[i][j] = Integer.parseInt(st.nextToken());}
        }

        int ans;
        DP[0][0] = MAP[0][0];
        DP[0][1] = MAP[0][1];
        DP[0][2] = MAP[0][2];
        for(int i=1; i<N; i++){
            DP[i][0] += Math.min(MAP[i][0]+DP[i-1][1], MAP[i][0]+DP[i-1][2]);
            DP[i][1] += Math.min(MAP[i][1]+DP[i-1][0], MAP[i][1]+DP[i-1][2]);
            DP[i][2] += Math.min(MAP[i][2]+DP[i-1][0], MAP[i][2]+DP[i-1][1]);
        }
        ans = Math.min(Math.min(DP[N-1][0], DP[N-1][1]), DP[N-1][2]);
        bw.write(String.valueOf(ans));
        bw.flush();

    }
}

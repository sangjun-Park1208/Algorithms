import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static long ans;
    static long[] input;
    static long[] count;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve() throws IOException{
        for(int i=1; i<=N; i++)
            input[i] += input[i-1];

        for(int i=0; i<=N; i++)
            count[(int)(input[i]%M)]++;

        for(int i=0; i<=M; i++){
            if(count[i] == 0) continue;
            ans += (count[i] * (count[i]-1)) / 2;
        }
        System.out.println(ans);
    }
    
    static void getInput() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = 0;

        input = new long[N+1];
        count = new long[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) input[i] = Integer.parseInt(st.nextToken());
    }
}
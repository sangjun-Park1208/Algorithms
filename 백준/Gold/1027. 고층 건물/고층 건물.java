import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static long ans;
    static double slope;
    static long[] input, visible;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve(){
        for(int i=1; i<N; i++){
            visible[i]++;
            visible[i+1]++;
            slope = input[i+1] - input[i];
            for(int j=i+2; j<=N; j++){
                if((double)(input[j]-input[i])/(j-i) > slope){ // 보임
                    slope = (double)(input[j]-input[i])/(j-i);
                    visible[i]++;
                    visible[j]++;
                }
            }
        }

        ans = 0;
        for(int i=1; i<=N; i++) ans = Math.max(ans, visible[i]);
        System.out.println(ans);
    }

    static void getInput() throws IOException{
        N = Integer.parseInt(br.readLine());
        input = new long[N+1];
        visible = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) input[i] = Integer.parseInt(st.nextToken());
    }
}
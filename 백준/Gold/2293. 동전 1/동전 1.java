import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static Integer[] P;
    static int sum, K, cnt;
    public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    P = new Integer[N];
    for(int i=0; i<N; i++){P[i] = Integer.parseInt(br.readLine());}
    Arrays.sort(P, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        } 
    });

    int[] dp = new int[K+1];
    dp[0] = 1;
    for(int i=0; i<N; i++){
        for(int j=P[i]; j<K+1; j++){
            dp[j] = dp[j]+dp[j-P[i]];
        }
    }
    bw.write(String.valueOf(dp[K]));
    bw.flush();
    
    }
}

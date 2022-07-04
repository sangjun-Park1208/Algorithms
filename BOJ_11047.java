import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11047 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = 0;
        int sum = 0;

        int[] V = new int[N];
        for(int i=0; i<N; i++) {V[i] = Integer.parseInt(br.readLine());}

        while(sum < K){
            if(K-sum >= V[N-1]){
                sum += V[N-1];
                M++;
            }
            else
                N--;
        }
        bw.write(String.valueOf(M));
        bw.flush();
    }
}

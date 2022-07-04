import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_11399 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] P = new int[N];
        for(int i=0; i<N; i++) {P[i] = Integer.parseInt(st.nextToken());}

        Arrays.sort(P);
        int sum =0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<=i; j++)
                sum += P[j];
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        Integer[] S = new Integer[N];
        Integer[] Diff = new Integer[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(S);

        for(int i=0; i<N-1; i++){
            Diff[i] = S[i+1]-S[i];
        }
        Arrays.sort(Diff, Comparator.reverseOrder());

        int sum = 0;
        for(int i=K-1; i<N-1; i++){
            sum += Diff[i];
        }

        bw.write(String.valueOf(sum));
        bw.flush();

        
    }
}

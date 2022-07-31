import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] S = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) { S[i] = Integer.parseInt(st.nextToken()); }

        Arrays.sort(S);

        int max = 0;
        
        for(int i=0; i<N; i++){
            max += S[i];
            if(i==N-1){
                break;
            }
            if(max < S[i+1]-1){
                break;
            }
        }
        max++;

        if(S[0] > 1){
            bw.write(String.valueOf(1));
            bw.flush();
            return;
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
}

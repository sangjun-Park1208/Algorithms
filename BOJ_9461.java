import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9461 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int D = 0;
        

        for(int i=1; i<=N; i++){
            D = Integer.parseInt(br.readLine());
            long [] P = new long[101];
            
            P[1] = 1; P[2] = 1; P[3] = 1; P[4] = 2; P[5] = 2;

            for(int j=6; j<=D; j++){ P[j] = P[j-1] + P[j-5]; }

            bw.write(String.valueOf(P[D])  + "\n");
        }        
        bw.flush();
    }
}

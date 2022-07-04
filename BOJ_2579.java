import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2579 {
    public static void main(String[] args) throws Exception{        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] S = new int[301];
        for(int i=0; i<N; i++) { S[i] = Integer.parseInt(br.readLine()); }
        
        if(N==1){
            bw.write(String.valueOf(S[0]));
            bw.flush();
            return;
        }
        int[] D = new int[301];
        D[0] = S[0];
        D[1] = S[0] + S[1];
        D[2] = Math.max(S[0]+S[2], S[1]+S[2]);
        
        for(int i=3; i<N; i++) { D[i] = Math.max(D[i-3] + S[i] + S[i-1], D[i-2] + S[i]); }
        bw.write(String.valueOf(D[N-1]));
        bw.flush();
    }

    // static void DP(int[] D, int[] S) {
    //     if()
    // }
}

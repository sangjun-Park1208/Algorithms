import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static int[] Ans;
    public static void main(String[] args) throws IOException{
        getInput();
        Solve(0);
        bw.flush();
    }
    
    static void getInput() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Ans = new int[M];
    }

    static void Solve(int depth) throws IOException{
        if(depth == M){
            for(int i=0; i<M; i++) 
                bw.write(Ans[i] + " ");
            bw.write("\n");
            return;
        }
        for(int i=1; i<=N; i++){
            Ans[depth] = i;
            Solve(depth+1);
        }

    }
}
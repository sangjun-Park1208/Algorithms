import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, ans;
    static int[] A, D;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve() {
        for(int i=0; i<N; i++)
            for(int j=0; j<i; j++)
                if(A[j] < A[i]) 
                    D[i] = Math.max(D[j]+1, D[i]);
        ans = D[0];
        for(int i=1; i<N; i++) ans = Math.max(ans, D[i]);
        System.out.println(ans);   
    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = new int[N];
        D = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            D[i] = 1;
        }
    }
}
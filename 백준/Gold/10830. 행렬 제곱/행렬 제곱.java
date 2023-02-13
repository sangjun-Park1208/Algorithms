import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static long B;
    static long[][] M, Msq, ans;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        ans = Solve(B);
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) System.out.print(ans[i][j]%1000 + " ");
            System.out.println();
        }
    } 

    static long[][] Solve(long r) throws IOException {
        if(r==2) return Msq;
        if(r==1) return M;

        long[][] tmp = Solve(r/2);
        long[][] ans = new long[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    ans[i][j] += (tmp[i][k] * tmp[k][j]);
                }
                ans[i][j] %= 1000;
            }
        }
        if(r%2 == 1){
            long[][] ans2 = new long[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    for(int k=0; k<N; k++){
                        ans2[i][j] += (ans[i][k] * M[k][j]);
                    }
                    ans2[i][j] %= 1000;
                }
            }
            return ans2;
        }
        return ans;
    }
     
    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        M = new long[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) M[i][j] = Long.parseLong(st.nextToken());
        }
        
        Msq = new long[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    Msq[i][j] += M[i][k] * M[k][j];
                }
            }
        }
    }
}
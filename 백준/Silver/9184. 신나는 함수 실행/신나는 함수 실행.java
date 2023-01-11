import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int A, B, C;
    static int[][][] DP;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        DP = new int[21][21][21];
        Solve();
        bw.flush();
    }

    static void Solve() throws IOException {
        while(true){
            getInput();
            if(A == -1 && B == -1 && C == -1) return;
            initDP();
            bw.write("w(" + A + ", " + B + ", " + C + ") = " + useRecursive(A, B, C) + "\n");
        }
    }
    
    static int useRecursive(int a, int b, int c) {
        
        if(inRange(a, b, c) && DP[a][b][c] != 0) return DP[a][b][c];
        
        if(a <= 0 || b <= 0 || c <= 0) return 1;
        
        if(a > 20 || b > 20 || c > 20) return DP[20][20][20] = useRecursive(20, 20, 20);
        
        if(a < b && b < c) return DP[a][b][c] = useRecursive(a, b, c-1) + useRecursive(a, b-1, c-1) - useRecursive(a, b-1, c);
        
        return DP[a][b][c] = useRecursive(a-1, b, c) + useRecursive(a-1, b-1, c) + useRecursive(a-1, b, c-1) - useRecursive(a-1, b-1, c-1);
    }
    
    static boolean inRange(int a, int b, int c){
        return (0<=a && a<=20) && (0<=b && b<=20) && (0<=c && c<=20);
    }

    static void initDP(){
        for(int i=0; i<=20; i++)
            for(int j=0; j<=20; j++)
            Arrays.fill(DP[i][j], 0);
    }
    
    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    }
}
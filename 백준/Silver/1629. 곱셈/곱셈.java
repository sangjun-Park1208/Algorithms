import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static long A, B, C, Asq;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        System.out.println(Solve(B) % C);
    } 

    static long Solve(long res) throws IOException {
        if(res == 2) return Asq;
        if(res == 1) return A;
        long tmp = Solve(res/2) % C;
        tmp *= tmp;
        tmp %= C;
        if(res%2 == 1) {tmp *= A; tmp %= C;}
        
        return tmp;
    }
     
    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Asq = A*A;
    }
}
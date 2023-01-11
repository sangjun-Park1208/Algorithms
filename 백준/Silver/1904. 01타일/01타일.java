import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    static int N;
    static long[] DP;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        System.out.println(Solve(N)%15746);
    }

    static long Solve(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        if(DP[n] != 0) return DP[n];
        return DP[n] = (Solve(n-1) + Solve(n-2))%15746;
    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        DP = new long[N+2];
        DP[1] = 1;
        DP[2] = 2;
    }
}
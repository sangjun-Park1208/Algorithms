import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int ans1, ans2;
    static int[] DP;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ans1 = ans2 = 0;
        getInput();
        Solve1(N);
        Solve2();
        bw.write(ans1 + " " + ans2);
        bw.flush();
    }

    static int Solve1(int n) {
        if(n==1 || n==2){
            ans1++;
            return 1;
        }
        return Solve1(n-1) + Solve1(n-2);
    }

    static void Solve2() {
        DP[1] = DP[2] = 1;
        for(int i=3; i<=N; i++){
            ans2++;
            DP[i] = DP[i-1] + DP[i-2];
        }
    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        DP = new int[N+1];
    }
}
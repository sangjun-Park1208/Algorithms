import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] input, DP;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve() throws IOException{
        for(int i=3; i<=N; i++){
            DP[i] = Math.max(DP[i-1], Math.max(DP[i-2]+input[i], input[i-1]+input[i]+DP[i-3]));
        }
        System.out.println(DP[N]);
    }
    
    static void getInput() throws IOException{
        N = Integer.parseInt(br.readLine());
        input = new int[N+2];
        DP = new int[N+2];
        for(int i=1; i<=N; i++)
            input[i] = Integer.parseInt(br.readLine());
        DP[1] = input[1];
        DP[2] = input[1] + input[2]; 
    }

    static void print() {
        System.out.println("DP :");
        for(int i=0; i<=N; i++) System.out.print(DP[i] + " ");
        System.out.println();
    }
}
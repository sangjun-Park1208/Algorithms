import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static int N, ans;
    static int[] input, copy, D;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve() {
        for(int i=0; i<N; i++)
            for(int j=0; j<i; j++)
                if(input[j] < input[i])
                    D[i] = Math.max(D[j]+1, D[i]);
        
        ans = D[0];
        for(int i=1; i<N; i++) ans = Math.max(ans, D[i]);
        System.out.println(N-ans);   
    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        copy = new int[N];
        D = new int[N];
        check = new boolean[N];
        Arrays.fill(check, false);
        for(int i=0; i<N; i++){
            copy[i] = input[i] = Integer.parseInt(br.readLine());
            D[i] = 1;
        }
    }
}
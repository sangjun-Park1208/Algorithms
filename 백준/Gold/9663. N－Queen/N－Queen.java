import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    static int N, ans;
    static int[] row;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve(0);
        System.out.println(ans);
    }

    static void Solve(int depth) {
        if(depth == N) {
            ans++;
            return;
        }

        for(int i=0; i<N; i++){
            row[depth] = i;
            if(isPromising(depth)){
                Solve(depth+1);
            }
        }
    }

    static boolean isPromising(int cur) {
        for(int i=0; i<cur; i++){
            if(row[cur] == row[i]) return false;
            if(Math.abs(cur-i) == Math.abs(row[cur]-row[i])) return false;
        }
        return true;
    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        row = new int[N];
        ans = 0;
    }
}
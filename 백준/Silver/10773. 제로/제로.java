import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int K, ans;
    static int[] input;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve() {
        for(int i=0; i<K; i++){
            if(input[i] == 0){
                stack.pop();
                continue;
            }
            stack.add(input[i]);
        }
        for (int r : stack) ans += r;
        System.out.println(ans);
    }

    static void getInput() throws IOException{
        K = Integer.parseInt(br.readLine());
        input = new int[K];
        stack = new Stack<>();
        ans = 0;
        for(int i=0; i<K; i++) input[i] = Integer.parseInt(br.readLine());
    }
}
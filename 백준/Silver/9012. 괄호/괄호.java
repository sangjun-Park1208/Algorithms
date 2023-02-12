import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static char cur;
    static String[] input;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();
        Solve();
    }

    static void Solve() throws IOException {
        for(int i=0; i<N; i++){
            for(int j=0; j<input[i].length(); j++){
                if(stack.empty()){
                    stack.push(input[i].charAt(j));
                    continue;
                }

                cur = stack.peek();
                stack.push(input[i].charAt(j));
                if(cur == '(' && stack.peek() == ')'){
                    stack.pop(); 
                    stack.pop();
                }
            }

            if(!stack.empty()) bw.write("NO" + "\n");
            else bw.write("YES" + "\n");
            stack.clear();
        }
        bw.flush();
    }

    static void getInput() throws IOException{
        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        input = new String[N];
        for(int i=0; i<N; i++) input[i] = br.readLine();
    }
}
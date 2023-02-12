import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, cur, top;
    static int[] input;
    static ArrayList<Character> ans;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();
        Solve();
    }

    static void Solve() throws IOException {
        cur = 0;
        for(int i=1; i<=N; i++){
            while(true){
                if(stack.isEmpty()){
                    ans.add('+');
                    stack.push(++cur);
                    continue;
                }

                top = stack.peek();
                if(top < input[i]){
                    ans.add('+');
                    stack.push(++cur);
                    continue;
                }
                if(top == input[i]){
                    ans.add('-');
                    stack.pop();
                    break;
                }
                if(top > input[i]){
                    System.out.println("NO");
                    return;
                }
            }
        }
        
        for(int i=0; i<ans.size(); i++) bw.write(ans.get(i) + "\n");
        bw.flush();
    }

    static void getInput() throws IOException{
        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        input = new int[N+1];
        ans = new ArrayList<>();
        for(int i=1; i<=N; i++) input[i] = Integer.parseInt(br.readLine());
    }
}
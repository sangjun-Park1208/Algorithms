import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static String command;
    static int N;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        Solve();
    }

    static void Solve() throws IOException{
        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            if(command.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
                continue;
            }

            if(command.equals("top")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                    continue;
                }
                System.out.println(stack.peek());
                continue;
            }

            if(command.equals("size")){
                System.out.println(stack.size());
                continue;
            }

            if(command.equals("pop")){
                if(stack.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(stack.pop());
                continue;
            }

            if(command.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                    continue;
                }
                System.out.println(0);
                continue;
            }

        }
    }
}
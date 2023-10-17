import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean flag;
        while(true) {
            input = br.readLine();
            if(input.equals(".")) break; // 종료 조건
            flag = true;
            stack.clear();

            for(int i=0; i<input.length(); i++) {
                if(input.charAt(i) == '(' ||input.charAt(i) == '[') {
                    stack.add(input.charAt(i));
                    continue;
                }
                else if(input.charAt(i) == ')') {
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    else if(stack.peekLast() == '(') stack.pollLast();
                    else {
                        flag = false;
                        break;
                    }
                }
                else if(input.charAt(i) == ']') {
                    if(stack.isEmpty()) {
                        flag = false;
                        break;    
                    }
                    else if(stack.peekLast() == '[') stack.pollLast();
                    else {
                        flag = false;
                        break;
                    }
                }           
            }
            if(stack.isEmpty() && flag) bw.write("yes\n");
            else bw.write("no\n");
            
        }

        bw.flush();
        return;
    }

}
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i=N; i>=1; i--) {
            deque.addLast(i);
        }

        for(int i=0; i<N-1; i++) {
            deque.pollLast();
            deque.addFirst(deque.pollLast());
        }

        bw.write(String.valueOf(deque.peek()));
        bw.flush();
        return;
    }

}
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i=1; i<=N; i++) {
            deque.addLast(i);
        }

        bw.write("<");
        while(!deque.isEmpty()) {
            for(int k=0; k<K-1; k++) {
                deque.addLast(deque.pollFirst());
            }
            if(deque.size() == 1) bw.write(String.valueOf(deque.pollFirst()));
            else bw.write(String.valueOf(deque.pollFirst()) + ", ");
        }
        bw.write(">");
        bw.flush();
        return;
    }

}
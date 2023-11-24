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
        int M = Integer.parseInt(st.nextToken());

        int[] baskets = new int[N+1];
        for(int i=1; i<baskets.length; i++) {
            baskets[i] = 0;
        }

        int start = -1, end = -1, ball = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            ball = Integer.parseInt(st.nextToken());
            for(int k=start; k<=end; k++) {
                baskets[k] = ball;
            }

        }

        for(int i=1; i<baskets.length; i++) {
            bw.write(String.valueOf(baskets[i]) + " ");
        }
        bw.flush();

        return;
    }
    
}
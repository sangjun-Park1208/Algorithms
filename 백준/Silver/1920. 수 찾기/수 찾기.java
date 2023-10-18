import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, left, mid, right;
    static long[] input, target;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();

        Arrays.sort(input);

        for(int i=0; i<M; i++) {
            bw.write(String.valueOf(binarySearch(target[i])) + "\n");
        }

        bw.flush();
        return;
    }

    static int binarySearch(long t) {
        left = 0;
        right = N-1;
        while(left <= right) {
            mid = (left + right) / 2;
            if(input[mid] == t) return 1;
            if(input[mid] < t) left = mid+1;
            else if(input[mid] > t) right = mid-1;
        }
        return 0;
    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        input = new long[N];
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        target = new long[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
    }

}
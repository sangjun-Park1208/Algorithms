import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static long lower, upper;
    static long[] trees;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();

        Arrays.sort(trees);
        bw.write(String.valueOf(binarySearch()));

        bw.flush();
        return;
    }

    static long binarySearch() {
        long left = 0;
        long right = trees[trees.length-1];
        long mid, sum;
        while(left < right) {
            mid = (left + right) / 2;
            sum = 0;
            for(int i=0; i<trees.length; i++) { // 뒤에서부터 점수계산
                if(trees[i] < mid) continue;
                sum += trees[i] - mid;
            }

            if(sum < M) { // 합이 아직 모자람 : 톱의 높이를 낮춰야 함.
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left-1;
    }

    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        trees = new long[N];
        for(int i=0; i<N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
        }
    }

}
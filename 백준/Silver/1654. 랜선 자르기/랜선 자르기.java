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
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] LANs = new long[K];
        for(int i=0; i<K; i++) {
            LANs[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(LANs);

        long min = 0;
        long max = LANs[K-1] + 1;
        long mid;
        long count;
        while(min < max) {
            mid = (min + max) / 2;
            count = 0;
            for(int i=0; i<LANs.length; i++) {
                count += (LANs[i] / mid);
            }

            if(count < N) { // 개수가 기준치에 못 미침 == 더 잘게 잘라야 함.
                max = mid; // 최댓값을 줄임
            } else { // count >= N : 개수는 충족함 == 더 크게 잘라도 만족할수도 있음
                min = mid + 1; // 최솟값을 늘림
            }

        }

        bw.write(String.valueOf(min-1));
        bw.flush();
        return;
    }

}
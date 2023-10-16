import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();
        int answer = 0;
        int cur = 666;
        int cnt = 0;
        while(true) {
            if(Integer.toString(cur).contains("666")) {
                answer = cur;
                cnt++;
            }
            cur++;
            if(cnt == N) break;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        return;
    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
    }
}
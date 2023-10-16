import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static boolean[][] Map;
    static int N;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();
        int answer = 0;
        for(int i=0; i<=100; i++) {
            for(int j=0; j<=100; j++) {
                if(Map[i][j]) answer++;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        return;
    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        int si, sj;
        Map = new boolean[101][101];
        for(int k=0; k<N; k++) {
            st = new StringTokenizer(br.readLine());
            si = Integer.parseInt(st.nextToken());
            sj = Integer.parseInt(st.nextToken());
            for(int i=0; i<10; i++) {
                for(int j=0; j<10; j++) {
                    Map[si+i][sj+j] = true;
                }
            }
        }
    }
}
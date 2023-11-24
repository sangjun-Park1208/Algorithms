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

        int[][] first = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                first[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] second = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                second[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] answer = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                answer[i][j] = first[i][j] + second[i][j];
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                bw.write(String.valueOf(answer[i][j]) + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        return;
    }
    
}
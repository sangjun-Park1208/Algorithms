import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] table = new int[10][10];

        for(int i=1; i<=9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=9; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = -1;
        int mi = 0, mj = 0;

        for(int i=1; i<=9; i++) {
            for(int j=1; j<=9; j++) {
                if(max <= table[i][j]) {
                    max = table[i][j];
                    mi = i; mj = j;
                }
            }
        }

        bw.write(String.valueOf(max) + "\n" + mi + " " + mj);
        bw.flush();
        return;
    }
    
}
import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br;
    static BufferedWriter bw;
    static int N, L, tmp;
    static int[][] Map;
    static boolean flag;
    static boolean[][] isSlope_row; // 가로 방향 (j++)
    static boolean[][] isSlope_col; // 세로 방향 (i++)

    public static void main(String[] args) throws Exception{
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();
        int answer = 0;

        for(int i=0; i<N; i++) {
            if(solution(true, i)) answer++;
            if(solution(false, i)) answer++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static boolean solution(boolean horizontal, int k) {
        if(horizontal) {
            for(int i=0; i<N-1; i++) {
                if(Map[k][i] == Map[k][i+1]) continue;

                if(Math.abs(Map[k][i] - Map[k][i+1]) > 1) return false;

                if(Map[k][i] - Map[k][i+1] == 1) { // 내려감
                    for(int j=i+1; j<=i+L; j++) {
                        if(j >= N) return false; // 벽 넘어감
                        if(Map[k][i+1] != Map[k][j]) return false; // 높이가 다름
                        if(isSlope_row[k][j]) return false; // 이미 경사로가 있음
                        isSlope_row[k][j] = true;
                    }
                } else if(Map[k][i] - Map[k][i+1] == -1) { // 올라감
                    for(int j=i; j>i-L; j--) {
                        if(j < 0) return false;
                        if(Map[k][i] != Map[k][j]) return false; // 높이가 다름
                        if(isSlope_row[k][j]) return false;
                        isSlope_row[k][j] = true;
                    }
                }
            }
        } else {
            for(int i=0; i<N-1; i++) {
                if(Map[i][k] == Map[i+1][k]) continue;

                if(Math.abs(Map[i][k] - Map[i+1][k]) > 1) return false;

                if(Map[i][k] - Map[i+1][k] == 1) { // 내려감
                    for(int j=i+1; j<=i+L; j++) {
                        if(j >= N) return false; // 벽 넘어감
                        if(Map[i+1][k] != Map[j][k]) return false; // 높이가 다름
                        if(isSlope_col[j][k]) return false; // 이미 경사로가 있음
                        isSlope_col[j][k] = true;
                    }
                } else if(Map[i][k] - Map[i+1][k] == -1) { // 올라감
                    for(int j=i; j>i-L; j--) {
                        if(j < 0) return false;
                        if(Map[i][k] != Map[j][k]) return false; // 높이가 다름
                        if(isSlope_col[j][k]) return false;
                        isSlope_col[j][k] = true;
                    }
                }
            }
        }
       
        return true;
    }

    static void getInput() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        Map = new int[N][N];
        isSlope_row = new boolean[N][N];
        isSlope_col = new boolean[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

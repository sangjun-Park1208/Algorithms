import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] DP;
    static int[][] pm; // 순열
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] input = new int[3];
        for(int i=0; i<N; i++)
            input[i] = Integer.parseInt(st.nextToken());
        if(N==1)
            input[1] = input[2] = 0;
        if(N==2)
            input[2] = 0;

        
        DP = new int[61][61][61];
        pm = new int[6][3]; // 순열
        pm[0][0] = 9; pm[0][1] = 3; pm[0][2] = 1;
        pm[1][0] = 9; pm[1][1] = 1; pm[1][2] = 3;
        pm[2][0] = 3; pm[2][1] = 9; pm[2][2] = 1;
        pm[3][0] = 3; pm[3][1] = 1; pm[3][2] = 9;
        pm[4][0] = 1; pm[4][1] = 9; pm[4][2] = 3;
        pm[5][0] = 1; pm[5][1] = 3; pm[5][2] = 9;

        Queue<Position> queue = new LinkedList<>();
        Position pos = new Position(0, 0, 0);
        queue.add(pos);

        for(int i=0; i<61; i++){
            for(int j=0; j<61; j++) Arrays.fill(DP[i][j], -1);
        }
        DP[0][0][0] = 0;

        int row, col, height;
        while(!queue.isEmpty()){
            pos = queue.poll();
            for(int i=0; i<6; i++){
                row = pos.r + pm[i][0];
                col = pos.c + pm[i][1];
                height = pos.h + pm[i][2];
                if(row >= input[0]) row = input[0];
                if(col >= input[1]) col = input[1];
                if(height >= input[2]) height = input[2];
                if(row == input[0] && col == input[1] && height == input[2]){
                    DP[row][col][height] = DP[pos.r][pos.c][pos.h] + 1;
                    bw.write(String.valueOf(DP[row][col][height]));
                    bw.flush();
                    return;
                }
                if(DP[row][col][height] < 0){
                    DP[row][col][height] = DP[pos.r][pos.c][pos.h] + 1;
                    queue.add(new Position(row, col, height));
                    continue;
                }
                DP[row][col][height] = DP[pos.r][pos.c][pos.h] + 1;
            }
        }
    }

    static class Position{
        int r, c, h;
        public Position(int r, int c, int h){
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }
}

import java.io.*;
import java.util.*;


public class Main {
    static long max, min;
    static int N;
    static int[] numbers;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] operations = new int[4];
        for(int i=0; i<4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }


        max = -1000000001L;
        min = 10000000000L;

        backtracking(operations, numbers[0], 0);
        bw.write(String.valueOf(max) + "\n");
        bw.write(String.valueOf(min));
        bw.flush();
        

    }

    static void backtracking(int[] operations, long num, int depth) {
        // 종료조건
        if(depth == N-1) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i=0; i<4; i++) {
            if(operations[i] > 0) {
                operations[i]--;
                switch(i) {
                    case 0:
                        backtracking(operations, num + numbers[depth+1], depth+1);
                        break;
                    case 1:
                        backtracking(operations, num - numbers[depth+1], depth+1);
                        break;
                    case 2:
                        backtracking(operations, num * numbers[depth+1], depth+1);
                        break;
                    case 3:
                        backtracking(operations, num / numbers[depth+1], depth+1);
                        break;
                }
                operations[i]++;
            }
        }
    }
}

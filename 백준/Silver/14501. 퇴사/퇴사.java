import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br;
    static int[][] Consulting;
    static int[] DPTable;
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();

        for(int i=N; i>=1; i--) {
            if(Consulting[i][0] + i > N+1) { // 최대 날짜를 초과하는 경우 : 상담 불가
                DPTable[i] = DPTable[i+1];
                continue;
            }

            DPTable[i] = Math.max(Consulting[i][1] + DPTable[Consulting[i][0] + i], DPTable[i+1]);
        }
        bw.write(String.valueOf(DPTable[1]));
        bw.flush();
    }

    static void getInput() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Consulting = new int[N+1][2]; // 1일~N일, [i][0]: 상담완료까지 걸리는 시간, [i][1]: 받을 수 있는 금액
        DPTable = new int[N+2]; // 현재 날짜까지의 최대 금액
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            Consulting[i][0] = Integer.parseInt(st.nextToken());
            Consulting[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}

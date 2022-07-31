import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] T = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i][0] = Integer.parseInt(st.nextToken());
            T[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(T, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> T_time = new PriorityQueue<>();
        T_time.add(T[0][1]); // 가장 빨리 시작하는 강의의 종료 시간
        for(int i=1; i<N; i++){
            if(T_time.peek() <= T[i][0])
                T_time.poll();
            T_time.add(T[i][1]);
        }
        bw.write(String.valueOf(T_time.size()));
        bw.flush();

        // ArrayList<Integer> T_time = new ArrayList<>();
        // int C = 1;
        // T_time.add(T[0][1]); // 가장 빨리 시작하는 강의의 종료 시간
        // for(int i=1; i<N; i++){
        //     Collections.sort(T_time);
        //     if(T_time.get(0) <= T[i][0]){
        //         T_time.set(0, T[i][1]);
        //     }
        //     else{
        //         C++;
        //         T_time.add(T[i][1]);
        //     }
        // }

        // bw.write(String.valueOf(C));
        // bw.flush();
    }
}

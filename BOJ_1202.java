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

public class BOJ_1202 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] MV = new int[N][2]; // MV[i][0] : i번째 보물의 무게, MV[i][1] : i번째 보물의 가격
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            MV[i][0] = Integer.parseInt(st.nextToken());
            MV[i][1] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> C = new ArrayList<>();
        for(int i=0; i<K; i++){ C.add(Integer.parseInt(br.readLine())); }

        Arrays.sort(MV, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) // 무게가 같으면 높은 가격 순으로 정렬(오름차순)
                    return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        // 가방의 수용 가능 무게에 따라 내림차순 정렬
        Collections.sort(C, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 : 각 보석 당 무게가 낮은 순서대로 정렬

        long ans = 0;
        int j=0;
        for(int i=0; i<K; i++){
            while(j<N && MV[j][0] <= C.get(i)){
                PQ.offer(MV[j][1]);
                j++;
            }
            if(!PQ.isEmpty()){
                ans += PQ.poll();
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}

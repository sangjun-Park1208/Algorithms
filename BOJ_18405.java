import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18405 {
    public static <T> void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] MAP = new int[N+2][N+2];
        PriorityQueue<Pair> A = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(BOJ_18405.Pair o1, BOJ_18405.Pair o2) {
                return o1.key - o2.key;
            }
        });
        int[] move_i = {-1, 1, 0, 0};
        int[] move_j = {0, 0, -1, 1};

        int num;
        ArrayList<Pair> B = new ArrayList<>();
        Pair pair;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){ 
                num = Integer.parseInt(st.nextToken());
                if(num != 0){
                    pair = new Pair(num, i, j);
                    B.add(pair);
                }
                MAP[i][j] = num; 
            }
        }
        while(B.size() > 0){
            A.add(B.remove(0));
        }


        for(int i=0; i<=N; i++) {MAP[0][i] = MAP[i][0] = MAP[N+1][i] = MAP[i][N+1] = -1;} // 가장자리 : -1
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int next_i, next_j;
        Pair p, q;

        for(int i=1; i<=S; i++){

            while(A.size() > 0){
                p = A.poll();
                for(int k=0; k<4; k++){
                    next_i = p.y + move_i[k];
                    next_j = p.x + move_j[k];
    
                    if(MAP[next_j][next_i] != 0) continue;
                    q = new Pair(p.key, next_i, next_j);
                    MAP[next_j][next_i] = p.key;
    
                    if(q.x == Y && q.y == X){
                        bw.write(String.valueOf(q.key));
                        bw.flush();
                        return;
                    }
                    B.add(q);
                }
            }
            // for(int e=1; e<=N; e++){
            //     for(int u=1; u<=N; u++){
            //         System.out.print(MAP[e][u] + " ");
            //     }
            // }
            // for문 끝나고 한번에 PQ에 다 넣기
            while(B.size() > 0){
                A.add(B.remove(0));
            }
        }
        bw.write(String.valueOf(0));
        bw.flush();
    }
    static class Pair{
        Integer key;
        Integer x;
        Integer y;
        public Pair(Integer key, Integer x, Integer y){
            this.key = key; 
            this.x = x;
            this.y = y;
        }
        public Integer getKey(){ return key; }
        public Integer getX(){ return x; }
        public Integer getY(){ return y; }
    }
}

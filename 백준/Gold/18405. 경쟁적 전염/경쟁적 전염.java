import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static <T> void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] MAP = new int[N+2][N+2];
        PriorityQueue<Pair> A = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Main.Pair o1, Main.Pair o2) { // 오름차순 정렬
                return o1.key - o2.key;
            }
        });
        int[] move_i = {0, 0, -1, 1};
        int[] move_j = {-1, 1, 0, 0};
        for(int i=0; i<=N; i++) {MAP[0][i] = MAP[i][0] = MAP[N+1][i] = MAP[i][N+1] = -1;} // 가장자리 : -1

        int num;
        ArrayList<Pair> B = new ArrayList<>();
        Pair pair;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){ 
                num = Integer.parseInt(st.nextToken());
                if(num != 0){
                    pair = new Pair(num, i, j);
                    A.add(pair);
                }
                MAP[i][j] = num; 
            }
        }
        while(A.size() > 0){ B.add(A.poll());}

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int next_i, next_j, s;
        Pair p, q;
        int depth=1;

        if(S==0){
            bw.write(String.valueOf(MAP[X][Y]));
            bw.flush();
            return;
        }
        if(MAP[X][Y] != 0){
            bw.write(String.valueOf(MAP[X][Y]));
            bw.flush();
            return;
        }

        while(B.size() > 0 && depth <= S){ // depth 관리를 어떻게 할 것인지.
            s = B.size();
            for(int i=0; i<s; i++){
                p = B.remove(0);
                for (int k = 0; k < 4; k++) { // Queue의 헤드마다 상하좌우 체크
                    next_i = p.y + move_i[k];
                    next_j = p.x + move_j[k];
    
                    if (MAP[next_j][next_i] != 0) continue; 
                    q = new Pair(p.key, next_j, next_i); // 0이 있으므로 바이러스가 할당됨
                    MAP[next_j][next_i] = p.key;
    
                    if (q.y == Y && q.x == X) {
                        bw.write(String.valueOf(q.key));
                        bw.flush();
                        return;
                    }
                    B.add(q);

                }
            }
            depth++;
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
    }
}

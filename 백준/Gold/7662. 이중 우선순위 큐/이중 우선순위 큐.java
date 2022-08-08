import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int K, C, V;
        int idx, flg_cnt;

        boolean[] flag = new boolean[10001];
        Pair p;
        PriorityQueue<Pair> maxPQ = new PriorityQueue<>(new Comparator<Pair>() {

            @Override
            public int compare(Pair o1, Pair o2) {
                if(o2.val > o1.val) return 1;
                if(o2.val < o1.val) return -1;
                return 0;
            }
            
        });
        PriorityQueue<Pair> minPQ = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o2.val > o1.val) return -1;
                if(o2.val < o1.val) return 1;
                return 0;
            }
        });
        for(int i=0; i<T; i++){
            K = Integer.parseInt(br.readLine());
            flag = new boolean[1000001];
            flg_cnt = 0;
            for(int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                C = st.nextToken().charAt(0);
                V = Integer.parseInt(st.nextToken());
                if(C == 73) { // (I) 인 경우
                    p = new Pair(V, flg_cnt);
                    flag[flg_cnt++] = false;
                    maxPQ.add(p); minPQ.add(p);
                }
                if(C == 68) { // (D) 인 경우
                    if(minPQ.isEmpty() || maxPQ.isEmpty()) continue;    
                    if(V == -1){ // minPQ에서 삭제
                        idx = minPQ.peek().idx;
                        flag[idx] = true;
                        minPQ.poll();
                    }
                    if(V == 1){ // maxPQ에서 삭제
                        idx = maxPQ.peek().idx;
                        flag[idx] = true;
                        maxPQ.poll();
                    }
                    while(!minPQ.isEmpty() && flag[minPQ.peek().idx]) minPQ.poll();
                    while(!maxPQ.isEmpty() && flag[maxPQ.peek().idx]) maxPQ.poll();
                }
            }

            int chk=0;
            for(int k=0; k<flg_cnt; k++){
                if(!flag[k]){bw.write(maxPQ.peek().val + " " + minPQ.peek().val + "\n"); chk = 1; break;}
            }

            if (chk == 0) bw.write("EMPTY" + "\n");
            
                
            maxPQ.clear(); minPQ.clear();            
        }
        bw.flush();
    }
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;
        Pair(int val, int idx){ this.val = val; this.idx = idx; }
        @Override
        public int compareTo(Main.Pair o) { return 0;}
    }

}

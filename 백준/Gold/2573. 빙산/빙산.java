import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int N, M, ans;
    static int[][] Map;
    static int[][] MinusMap;
    static Boolean[][] Visit1, Visit2;
    static Queue<Pair> Q;
    static Pair p1, p2, f1, f2;

    /* 상하좌우 */
    static int[] move_i = {-1, 1, 0, 0};
    static int[] move_j = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        MinusMap = new int[N][M];
        Visit1 = new Boolean[N][M];
        Visit2 = new Boolean[N][M];
        ans = 0;
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) Map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            Arrays.fill(MinusMap[i], 0);
            Arrays.fill(Visit1[i], false);
            Arrays.fill(Visit2[i], false);
        }

        Solve();
    }

    static void Solve() {

        while(isUnion()){ /* 한 덩어리인 동안 */ 
            for(int i=0; i<N; i++){
                Arrays.fill(MinusMap[i], 0);
                Arrays.fill(Visit1[i], false);
                Arrays.fill(Visit2[i], false);
            }
            BFS();
            ans++;
        }
        System.out.println(ans);
    }

    static void BFS(){
        f1 = findFirst();
        boolean c;
        Q = new LinkedList<Pair>();
        Q.add(new Pair(f1.i, f1.j)); // 첫 번째 빙산 요소

        int next_i, next_j;
        while(!Q.isEmpty()){
            p1 = Q.poll();
            Visit1[p1.i][p1.j] = true;
            for(int k=0; k<4; k++){
                c = false;
                next_i = p1.i + move_i[k];
                next_j = p1.j + move_j[k];
                if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= M) continue;
                if(Visit1[next_i][next_j]) continue;
                if(Map[next_i][next_j] == 0) {
                    MinusMap[p1.i][p1.j]++;
                    continue;
                }
                
                for (Pair p : Q) /* 대기 중인 큐에 중복 삽입 방지 */
                    if(p.i == next_i && p.j == next_j) {
                        c = true;
                        break;
                    }
                
                if(c) continue;
                Q.add(new Pair(next_i, next_j));
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                Map[i][j] -= MinusMap[i][j];
                if(Map[i][j] < 0) Map[i][j] = 0;
            }
        }
    }
    

    static Pair findFirst(){ 
        Pair first = new Pair(-1, -1);
        Boolean check = false;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(Map[i][j] == 0) continue;
                check = true;
                first = new Pair(i, j);
                break;
            }
            if(check) return first;
        }
        return first;
    }

    static Boolean isUnion(){
        f2 = findFirst();
        if(f2.i == -1 || f2.j == -1) { // 끝까지 하나의 덩어리만 남은 경우
            System.out.println(0);
            System.exit(0);
        }
        int next_i, next_j;
        Visit2[f2.i][f2.j] = true;

        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(f2.i, f2.j));
        while(!queue.isEmpty()){
            p2 = queue.poll();
            for(int k=0; k<4; k++){
                next_i = p2.i + move_i[k];
                next_j = p2.j + move_j[k];
                if(next_i <= 0 || next_j <= 0 || next_i >= N || next_j >= M) continue;
                if(Map[next_i][next_j] == 0 || Visit2[next_i][next_j]) continue;
                Visit2[next_i][next_j] = true;
                queue.add(new Pair(next_i, next_j));
            }
        }

        // 두 덩어리인 경우를 감지
        f2 = findFirst();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!Visit2[i][j] && Map[i][j] > 0) return false;
            }
        }
        return true;
    }

    static class Pair{
        int i, j;
        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

}
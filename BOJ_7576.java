import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] MAP = new int[N+2][M+2];
        for(int i=0; i<=M+1; i++){ MAP[0][i] = MAP[N+1][i] = -1;}
        for(int i=0; i<=N+1; i++){ MAP[i][0] = MAP[i][M+1] = -1;}
        int[] move_i = {0, 0, -1, 1}; // X
        int[] move_j = {-1, 1, 0, 0}; // Y

        int num;
        int zero=0; // 0 개수
        Queue<Pair> A = new LinkedList<>(); // 익은 토마토(1) 들의 LinkedList(Queue)
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                num = Integer.parseInt(st.nextToken());
                if(num == 0) zero++;
                if(num == 1) A.add(new Pair(i, j)); 
                MAP[i][j] = num;
            }
        }

        int zCnt = zero; // 0 카운트 변수 
        int next_i, next_j, chk, s; int ans = 0;
        Pair pair;
        
        while(A.size() > 0){
            s = A.size();
            chk = 0;
            for(int k=0; k<s; k++){ // 같은 depth
                pair = A.poll(); // Queue의 헤더
                for(int i=0; i<4; i++){ // 각 좌표 별 상/하/좌/우 검사
                    next_i = pair.x + move_i[i];
                    next_j = pair.y + move_j[i];
                    if(MAP[next_i][next_j] != 0) continue; // 0이 아니면 pass
    
                    // 0인 경우
                    zCnt--; chk++; // 0개수 줄이기 & 각 노드 별 상하좌우 중 하나라도 찍었으면 체크
                    MAP[next_i][next_j] = 1;
                    A.add(new Pair(next_i, next_j));
                }
            }
            if(chk>0) ans++;
        }

        if(zCnt == 0){ bw.write(String.valueOf(ans)); bw.flush(); return; }

        bw.write(String.valueOf(-1)); bw.flush();
        
    }
    static class Pair{
        Integer x;
        Integer y;
        public Pair(Integer x, Integer y){
            this.x = x;
            this.y = y;
        }
    }
}

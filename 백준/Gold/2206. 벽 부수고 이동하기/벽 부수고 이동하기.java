import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] MAP = new int[N+2][M+2];
        int[][] V_brk = new int[N+2][M+2];
        int[][] V_nrk = new int[N+2][M+2];
        for(int i=0; i<=N+1; i++){MAP[i][0] = MAP[i][M+1] = -1;} // 가장자리 : -1
        for(int i=0; i<=M+1; i++){MAP[0][i] = MAP[N+1][i] = -1;}
        for(int i=0; i<=N+1; i++){V_brk[i][0] = V_brk[i][M+1] = V_nrk[i][0] = V_nrk[i][M+1] = 1;}
        for(int i=0; i<=M+1; i++){V_brk[0][i] = V_brk[N+1][i] = V_nrk[0][i] = V_nrk[N+1][i] = 1;}
        String str;
        for(int i=1; i<=N; i++){
            str = br.readLine();
            for(int j=0; j<M; j++){MAP[i][j+1] = str.charAt(j)-'0';}
        }
        
        int[] move_i = {1, 0, 0, -1}; // 우/하/상/좌
        int[] move_j = {0, 1, -1, 0};
        V_nrk[1][1] = 1;

        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(1, 1, 1, 0));
        Pair p, q;
        int next_i, next_j, s;
        while(Q.size() > 0){ // 종료 조건 : 큐가 비어 있을 때
            s = Q.size();
            for(int i=0; i<s; i++){
                p = Q.poll();
                if (p.x == N && p.y == M) {
                    bw.write(String.valueOf(p.depth));
                    bw.flush();
                    return;
                }
                for(int j=0; j<4; j++){
                    next_i = p.x + move_i[j];
                    next_j = p.y + move_j[j];

                    if(next_i < 0 || next_i > N || next_j < 0 || next_j > M) continue;
  
                    if(MAP[next_i][next_j] == 0 && p.blk == 0) { // 다음 지점이 0인 경우 && 부순 횟수가 0인 경우
                        if(V_nrk[next_i][next_j] == 1) continue;
                        q = new Pair(next_i, next_j, p.depth+1, 0);
                        V_nrk[next_i][next_j] = 1;
                        Q.add(q);
                    } 
                    if(MAP[next_i][next_j] == 0 && p.blk == 1){ // 다음 지점이 0인 경우 && 부순 횟수가 1인 경우
                        if(V_brk[next_i][next_j] == 1) continue;
                        q = new Pair(next_i, next_j, p.depth+1, 1);
                        V_brk[next_i][next_j] = 1;
                        Q.add(q);
                    }
                    if(MAP[next_i][next_j] == 1 && p.blk == 0){ // 다음 지점이 1인 경우 && 부순 횟수가 0인 경우
                        if(V_brk[next_i][next_j] == 1) continue;
                        q = new Pair(next_i, next_j, p.depth+1, 1);
                        V_brk[next_i][next_j] = 1;
                        Q.add(q);
                    }
                    if(MAP[next_i][next_j] == 1 && p.blk == 1){ // 다음 지점이 1인 경우 && 부순 횟수가 1인 경우
                        continue;
                    }

                }

            }
        }
        bw.write(String.valueOf(-1));
        bw.flush();
    }
    static class Pair{
        Integer x;
        Integer y;
        Integer blk;
        Integer depth;
        public Pair(Integer x, Integer y, Integer depth, Integer blk){
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.blk = blk; // 벽을 부순 횟수
        }
    }
}

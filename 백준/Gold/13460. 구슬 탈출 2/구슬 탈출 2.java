import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, next_i, next_j, time, level;
    static char[][] Map;
    static Queue<RedBlue> queue;
    static Case hole, red, blue;
    static RedBlue redblue;
    static int[] move_i = {-1, 1, 0, 0};
    static int[] move_j = {0, 0, -1, 1};
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static class Case {
        int i, j, dist;
        public Case(int i, int j, int dist){
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    static class RedBlue {
        int ri, rj, bi, bj;
        public RedBlue (int ri, int rj, int bi, int bj) {
            this.ri = ri;
            this.rj = rj;
            this.bi = bi;
            this.bj = bj;
        } 
    }

    static void Solve() {
        time = 0;
        while(!queue.isEmpty()){

            /* 10번 초과 시 종료 */
            if(time++ >= 10) {
                System.out.println(-1);
                return;
            }

            /* 네 방향으로 기울이기 */
            level = queue.size();
            while(level-- > 0){
                redblue = queue.poll();
                for(int k=0; k<4; k++) {
                    red = moveDFS(k, redblue.ri, redblue.rj, 0);
                    blue = moveDFS(k, redblue.bi, redblue.bj, 0);
    
                    /* 파란색이 구멍에 빠짐 */
                    if(Map[blue.i][blue.j] == 'O') continue;
                    
                    /* 파란색은 안 빠지고, 빨간색만 빠짐 */
                    if(Map[red.i][red.j] == 'O') {
                        System.out.println(time);
                        return;
                    }
    
                    /* 빨간색과 파란색이 같은 위치에 있는 경우 */
                    if(red.i == blue.i && red.j == blue.j){
                        if(red.dist > blue.dist) { // 빨간색이 같은 방향에서 파란색보다 뒤에 있던 경우
                            red.i -= move_i[k]; // 빨간색을 뒤로 한 칸 뺀다.
                            red.j -= move_j[k];
                        }
                        else {
                            blue.i -= move_i[k];
                            blue.j -= move_j[k];
                        }
                    }
    
                    if(visited[red.i][red.j][blue.i][blue.j]) continue;
                    visited[red.i][red.j][blue.i][blue.j] = true;
    
                    queue.add(new RedBlue(red.i, red.j, blue.i, blue.j));
                }
            }
        }
        System.out.println(-1);
        return;
    }

    /* 이동한 거리 리턴 */
    static Case moveDFS(int k, int i, int j, int dist) { // k: 방향, dist: 움직인 거리
        next_i = i + move_i[k];
        next_j = j + move_j[k];
        if(Map[next_i][next_j] == '#') return new Case(i, j, dist);
        if(Map[next_i][next_j] == 'O') return new Case(next_i, next_j, dist+1);
        return moveDFS(k, next_i, next_j, dist+1);
    }

    static void getInput() throws IOException  {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String str; char a;
        Map = new char[N][M];
        queue = new LinkedList<>();
        visited = new boolean[N][M][N][M];

        for(int i=0; i<N; i++){
            str = br.readLine();
            for(int j=0; j<M; j++) {
                a = str.charAt(j);
                if(a == 'O') hole = new Case(i, j, 0);
                if(a == 'R') red = new Case(i, j, 0);
                if(a == 'B') blue = new Case(i, j, 0);
                Map[i][j] = a;
            }
        }
        queue.add(new RedBlue(red.i, red.j, blue.i, blue.j));
    }
}
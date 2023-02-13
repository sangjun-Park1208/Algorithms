import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, ans, next_i, next_j, r, c;
    static int[] move_i = {-1, 0, 1, 0};
    static int[] move_j = {0, 1, 0, -1};
    static int dir; // 상(0), 우(1), 하(2), 좌(3) -> 시계방향 증가
    static int[][] Map;
    static boolean[][] isClean;
    static boolean cleaned4way;
    static Pair curPos;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static class Pair {
        int i, j;
        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    static void Solve() throws IOException {
        while(true){
            isClean[curPos.i][curPos.j] = true; // 현재 칸 청소            
            cleaned4way = true;
            int blocked4way = 0;

            /* 네 방향 중, 청소되지 않은 칸이 있는 경우 체크 */
            for(int k=0; k<4; k++){
                next_i = curPos.i + move_i[k];
                next_j = curPos.j + move_j[k];
                if(next_i < 0 || next_i > N-1 || next_j < 0 || next_j > M-1) continue;
                if(Map[next_i][next_j] == 1){ // 벽으로 막힌 경우
                    blocked4way++;
                    continue;
                }
                if(!isClean[next_i][next_j]) { // 청소되지 않은 칸이 있는 경우
                    cleaned4way = false;
                    break;
                }
            }

            /* 네 방향 모두 벽으로 막힌 경우 */
            if(blocked4way == 4) {
                System.out.println(ans);
                return;
            }

            /* 네 방향 모두 청소된 경우 */
            if(cleaned4way){
                /* 후진 (방향 전환 x, 뒤로만) */
                next_i = curPos.i + move_i[(dir+2)%4];
                next_j = curPos.j + move_j[(dir+2)%4];

                if(Map[next_i][next_j] == 1){ // 후진 시 벽이 있으면 종료
                    System.out.println(ans);
                    return; 
                }

                /* 방향 유지한 채로 후진 */
                curPos.i = next_i;
                curPos.j = next_j;
                continue;
            }

            /* 청소되지 않은 칸이 있는 경우 */
            while(!cleaned4way){
                /* 방향 전환 */
                dir = (dir+3)%4;

                next_i = curPos.i + move_i[dir];
                next_j = curPos.j + move_j[dir];

                if(next_i < 0 || next_i > N-1 || next_j < 0 || next_j > M-1) continue;

                /* 전진 */
                if(!isClean[next_i][next_j] && Map[next_i][next_j] == 0){
                    curPos.i = next_i;
                    curPos.j = next_j;
                    ans++;
                    break;
                }

            }
        }
    }
     
    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        Map = new int[N+1][M+1];
        isClean = new boolean[N+1][M+1];
        ans = 1;
        curPos = new Pair(r, c);

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) Map[i][j] = Integer.parseInt(st.nextToken());
        }
    }
}
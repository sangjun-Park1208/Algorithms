import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[][] MAP;
    static boolean[][] visit;
    static int[] move_i = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] move_j = {0, 0, -1, 1};
    static int next_i, next_j;
    static int L, R, N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visit = new boolean[N+2][N+2];

        MAP = new int[N+2][N+2];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){MAP[i][j] = Integer.parseInt(st.nextToken());}
        }
        // print();

        int ans = 0;
        boolean flag = true;

        while(flag){
            if(solve() == 0){
                flag = false;
                break;
            }
            ans++;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static int solve(){
        int unionCnt = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(!visit[i][j]){ // 방문한 적 없다면
                    Queue<Location> queue = new LinkedList<>();
                    List<Location> list = new ArrayList<>();
                    Location location = new Location(i, j);
                    
                    queue.add(location);
                    list.add(location);

                    visit[location.i][location.j] = true;
                    int unionSum = MAP[location.i][location.j];

                    while(!queue.isEmpty()){
                        Location curPos = queue.poll();
                        for(int k=0; k<4; k++){
                            next_i = curPos.i + move_i[k];
                            next_j = curPos.j + move_j[k];
                            if(next_i < 1 || next_j < 1 || next_i > N || next_j > N) continue;
                            if(!visit[next_i][next_j] && isUnion(curPos.i, curPos.j, next_i, next_j)){
                                queue.add(new Location(next_i, next_j));
                                list.add(new Location(next_i, next_j));
                                visit[next_i][next_j] = true;
                                unionCnt++;
                                unionSum += MAP[next_i][next_j];
                            }

                        }
                    }
                    // MAP[i][j]에 대한 상하좌우 및 관련 연합들 모두 조사 완료
                    if(unionCnt > 0){
                        int avg = unionSum / list.size();
                        for(int t=0; t<list.size(); t++){
                            Location cur = list.get(t);
                            MAP[cur.i][cur.j] = avg;
                        }
                    }
                }

            }
        }
        initVisit();
        return unionCnt;
    }

    static void initVisit(){ // visit 배열 초기화
        for(int i=1; i<=N; i++) Arrays.fill(visit[i], false);
    }
    
    static boolean isUnion(int cur_i, int cur_j, int next_i, int next_j){ // 인구 차이 값이 L이상 R 이하인지 체크
        int chk = Math.abs(MAP[cur_i][cur_j] - MAP[next_i][next_j]);
        if(chk >= L && chk <= R) return true;
        return false;
    }

    static class Location{
        int i;
        int j;
        public Location(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    static void print(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++) System.out.print(MAP[i][j] + " ");
            System.out.println();
        }
    }
}

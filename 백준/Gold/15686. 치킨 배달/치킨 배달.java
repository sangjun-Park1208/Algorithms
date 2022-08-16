import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] MAP;
    static Position pos, pos2;
    static ArrayList<Position> C, H, B;
    static int N, M;
    static int min, tmp_min, ans;
    static int[] move_i = {-1, 1, 0, 0};
    static int[] move_j = {0, 0, -1, 1};
    static int next_i, next_j;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MAP = new int[N+1][N+1];
        int n;
        C = new ArrayList<>();
        H = new ArrayList<>();
        B = new ArrayList<>();
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                n = Integer.parseInt(st.nextToken());
                if(n == 2) C.add(new Position(i, j)); // C(치킨집)의 좌표들
                if(n == 1) H.add(new Position(i, j)); // H(집)의 좌표들
                MAP[i][j] = n;
            }
        }
        ans = Integer.MAX_VALUE;
        combination(0);
        bw.write(String.valueOf(ans));
        bw.flush();
    }
    static void combination(int cur){ // C: 치킨집, B: 조합, H: 집
        if(B.size() == M){ // 조합 하나 찾은 경우 == find()
            min = 0;
            for(int i=0; i<H.size(); i++){
                pos = H.get(i);
                tmp_min = Integer.MAX_VALUE;
                
                for(int k=0; k<B.size(); k++){
                    pos2 = B.get(k);
                    tmp_min = Math.min(tmp_min, Math.abs(pos.i - pos2.i) + Math.abs(pos.j - pos2.j));
                }
                min += tmp_min;
            }
            ans = Math.min(ans, min);
            return;
        }

        for(int i=cur; i<C.size(); i++){
            B.add(C.get(i));
            combination(i+1);
            B.remove(B.size()-1);
        }
    }

    static class Position{
        int i, j;
        public Position(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}

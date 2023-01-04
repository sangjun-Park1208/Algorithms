import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, ans, area;
    static int[][] Map, copyMap;
    static boolean[][] isVisit;
    static ArrayList<Pair> Empty;
    static Queue<Pair> Virus, Q;
    static int[] move_i = {-1, 1, 0, 0};
    static int[] move_j = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        copyMap = new int[N][M];
        isVisit = new boolean[N][M];
        Empty = new ArrayList<>();
        Virus = new LinkedList<>();
        
        ans = 0;
        for(int i=0; i<N; i++)
            Arrays.fill(isVisit[i], false);
        

        int t;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                t =  Integer.parseInt(st.nextToken());
                if(t == 0)
                    Empty.add(new Pair(i, j));
                if(t == 2)
                    Virus.add(new Pair(i, j));
                Map[i][j] = t;
            }
        }

        DFS(0);
        System.out.println(ans);
    }
    // 1.벽 3개 세우기
    // 2.바이러스 전파
    // 3.개수 세기
    // 4.최댓값 기록
    // 1~4 반복

    static void DFS(int r) { // 1.벽 세우기
        if(r==3){
            for(int i=0; i<N; i++) // deep copy
                for(int j=0; j<M; j++) 
                    copyMap[i][j] = Map[i][j];
            
            BFS(); // 2.바이러스 전파
            area = getSafeArea(); // 3.개수 세기
            if(ans < area) ans = area; // 4.최댓값 업데이트
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(Map[i][j] == 0){
                    Map[i][j] = 1; // 벽 세우기
                    DFS(r+1); // DFS 재귀 (벽 세우기)
                    Map[i][j] = 0; // 벽 없애기
                }
            }
        }
        return;
    }

    static void BFS() { // 바이러스 전파
        int next_i, next_j;
        Pair p;
        Q = new LinkedList<>();
        for(Pair pair : Virus) // deep copy
            Q.add(pair);
        
        while(!Q.isEmpty()){
            p = Q.poll();
            for(int k=0; k<4; k++){
                next_i = p.i + move_i[k];
                next_j = p.j + move_j[k];
                if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= M) continue;
                if(copyMap[next_i][next_j] == 0){
                    copyMap[next_i][next_j] = 2;
                    Q.add(new Pair(next_i, next_j));
                }
            }
        }
        
    }

    static int getSafeArea() {
        int ret = 0;
        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                if(copyMap[i][j] == 0) ret++;
            
        return ret;
    }

    static class Pair {
        int i, j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static void printcopyMap() {
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) System.out.print(copyMap[i][j] + " ");
            System.out.println();
        }
    }
    static void printMap() {
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) System.out.print(Map[i][j] + " ");
            System.out.println();
        }
    }
}
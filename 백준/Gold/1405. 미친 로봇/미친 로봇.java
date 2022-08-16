import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static double[] prob;
    static boolean[][] visit;
    static double ans = 0;
    static int N;
    static int[] move_i = {0, 0, 1, -1};
    static int[] move_j = {1, -1, 0, 0};
    static int next_i, next_j;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        prob = new double[4]; // [E,W,S,N]
        visit = new boolean[30][30];
        for(int i=0; i<30; i++){ visit[i][0] = visit[0][i] = true; }

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i=0; i<4; i++) prob[i] = Integer.parseInt(st.nextToken())/100.0;

        visit[15][15] = true;
        solve(new Node(1, 0, 15, 15));
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void solve(Node node){
        if(node.depth == N){ // 종료 조건
            ans += node.pb;
            visit[node.i][node.j] = false;
            return;
        }

        for(int k=0; k<4; k++){ // [E,W,S,N]
            if(prob[k] == 0) continue;
            next_i = node.i + move_i[k]; 
            next_j = node.j + move_j[k];
            if(visit[next_i][next_j]) continue; // 방문체크 되었다면 패스
            visit[next_i][next_j] = true; // 방문 체크
            solve(new Node(node.pb*prob[k], node.depth+1, next_i, next_j));
        }
        visit[node.i][node.j] = false;
    }

    static class Node{
        int i, j;
        double pb;
        int depth;
        public Node(double pb, int depth, int i, int j){
            this.pb = pb;
            this.depth = depth;
            this.i = i;
            this.j = j;
        }
    }

}

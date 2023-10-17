import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static BufferedWriter bw;
    static int N, M, V;
    static int[][] Map;
    static boolean[] isVisit;
    static ArrayDeque<Integer> queue;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();
        
        isVisit = new boolean[N+1];
        DFS(V);
        bw.write("\n");

        isVisit = new boolean[N+1];
        BFS();

        bw.flush();
        return;
    }

    static void DFS(int i) throws IOException {
        isVisit[i] = true;
        bw.write(String.valueOf(i) + " ");
        for(int j=1; j<=N; j++) {
            if(Map[i][j] > 0 && !isVisit[j]) {
                DFS(j);
            }
        }
    } 

    static void BFS() throws IOException {
        queue = new ArrayDeque<>();
        queue.add(V);
        isVisit[V] = true;
        int cur;
        while(!queue.isEmpty()) {
            cur = queue.poll();
            bw.write(String.valueOf(cur) + " ");

            for(int j=1; j<=N; j++) {
                if(Map[cur][j] > 0 && !isVisit[j]) {
                    queue.add(j);
                    isVisit[j] = true;
                }
            }
            
        }
    }

    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        Map = new int[N+1][N+1];
        int si, sj;
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            si = Integer.parseInt(st.nextToken());
            sj = Integer.parseInt(st.nextToken());
            Map[si][sj]++;
            Map[sj][si]++;
        }
    }

}
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, from, to;
    static boolean[][] Relation;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();

        int answer = bfs();
        bw.write(String.valueOf(answer));
        bw.flush();
        return;
    }

    static int bfs() {
        int retVal = -1;
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        isVisit[from] = true;

        queue.add(from);
        int cur, cnt;
        cnt = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k=0; k<size; k++) {
                cur = queue.poll();
                isVisit[cur] = true;
                if(cur == to) return cnt;
                for(int i=1; i<=N; i++) {
                    if(Relation[cur][i] && !isVisit[i]) {
                        queue.add(i);
                    }
                }
            }
            cnt++;
        }

        return retVal;
    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        Relation = new boolean[N+1][N+1];
        isVisit = new boolean[N+1];
        int si, sj;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            si = Integer.parseInt(st.nextToken());
            sj = Integer.parseInt(st.nextToken());
            Relation[si][sj] = true;
            Relation[sj][si] = true;
        }
    }

}
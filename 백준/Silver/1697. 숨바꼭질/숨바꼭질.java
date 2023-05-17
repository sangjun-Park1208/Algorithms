import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, K, cur, ans, qsize;
    static LinkedList<Integer> queue;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve() throws IOException {
        ans = 0;
        if(N == K) {
            System.out.println(ans);
            return;
        }

        while(!queue.isEmpty()) {
            qsize = queue.size();
            for(int i=0; i<qsize; i++) {
                cur = queue.poll();
                if(cur == K) {
                    System.out.println(ans);
                    return;
                }

                if(isBound(cur-1) && !isVisit[cur-1]) {
                    queue.add(cur-1);
                    isVisit[cur-1] = true;
                }
                if(isBound(cur+1) && !isVisit[cur+1]) {
                    queue.add(cur+1);
                    isVisit[cur+1] = true;
                }
                
                if(isBound(cur*2) && !isVisit[cur*2]) {
                    queue.add(cur*2);
                    isVisit[cur*2] = true;
                }
            }
            ans++;
        }
    }

    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();
        queue.add(N);

        isVisit = new boolean[100001];
    }

    static boolean isBound(int x) {
        if(x>=0 && x<=100000) return true;
        return false;
    }
}
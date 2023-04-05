import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, par1, par2;
    static int[][] input;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();
        Solve();
    }

    static void Solve() throws IOException {
        for(int i=0; i<M; i++) {
            /* 합집합 연산 수행 */
            if(input[i][0] == 0) {
                makeUnion(input[i][1], input[i][2]);
                continue;
            }

            /* 동일 집합 여부 출력 수행 */
            if(input[i][0] == 1) {
                if(isSameParent(input[i][1], input[i][2])) {
                    bw.write("YES"+"\n");
                    continue;
                }
                bw.write("NO"+"\n");
            }
        }
        bw.flush();
    }

    static void makeUnion (int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if(x == y) return;
        if(x < y) parent[y] = x;
        if(x > y) parent[x] = y;
    }
    
    static int findParent (int x) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    static boolean isSameParent (int x, int y) {
        x = findParent(x);
        y = findParent(y);
        if(x == y) return true;
        return false;
    }

    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[M][3];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
            input[i][2] = Integer.parseInt(st.nextToken());
        }

        parent = new int[N+1];
        for(int i=0; i<=N; i++) parent[i] = i;
    }

    static void printArr() {
        System.out.println("parent: ");
        for(int i=0; i<=N; i++) System.out.print(parent[i] + " ");
        System.out.println();
    }
}
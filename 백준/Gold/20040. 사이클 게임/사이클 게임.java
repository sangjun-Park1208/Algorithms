import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, rootA, rootB;
    static int[][] input;
    static int[] parent;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve() {
        for(int i=0; i<M; i++){
            if(isUnion(input[i][0], input[i][1])) {
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(0);
    }

    static boolean isUnion(int a, int b){
        rootA = findRoot(a);
        rootB = findRoot(b);
        if(rootA == rootB) return true;
        parent[rootB] = rootA;
        return false;
    }

    static int findRoot(int n){
        if(n == parent[n]) return n;
        return parent[n] = findRoot(parent[n]);
    }

    static void getInput() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[M][2];
        parent = new int[N];

        for(int i=0; i<N; i++) parent[i] = i;
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}
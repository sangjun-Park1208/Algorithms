import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, ans;
    static Queue<Pair> list;
    static int[] input, sum;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        getInput();
        Solve();
    }

    static void Solve() {
        Pair p;
        int accSum = 0;
        sum = new int[N+1];
        sum[0] = input[0];
        for(int i=1; i<=N; i++){
            accSum += input[i];
            sum[i] = accSum;
        }

        while(!list.isEmpty()){
            p = list.poll();
            System.out.println(sum[p.j] - sum[p.i-1]);
        }
    }

    static void getInput() throws IOException {
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        input = new int[N+1];
        input[0] = 0;
        for(int i=1; i<=N; i++) input[i] = Integer.parseInt(st.nextToken());

        list = new LinkedList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    static class Pair {
        int i, j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
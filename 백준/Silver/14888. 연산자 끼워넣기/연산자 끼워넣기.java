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
    static int N, min, max, tmp;
    static int[] A, op, count, input;
    static boolean[] visit;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();
        Solve(0);
        bw.write(max + "\n" + min);
        bw.flush();
    }

    static void Solve(int depth) {
        if(depth == N-1) {
            tmp = A[0];
            for(int i=1; i<N; i++){
                switch (input[i-1]) {
                    case 0:
                        tmp += A[i];
                        break;
                    case 1:
                        tmp -= A[i];
                        break;
                    case 2:
                        tmp *= A[i];
                        break;
                    case 3:
                        tmp /= A[i];
                        break;
                    default:
                        break;
                }
            }

            if(tmp > max) max = tmp;
            if(tmp < min) min = tmp;
            return;
        }

        for(int i=0; i<N-1; i++){
            if(visit[i]) continue;
            visit[i] = true; // 방문체크
            input[depth] = count[i];
            Solve(depth+1);
            visit[i] = false;
        }
    }

    static void getInput() throws IOException {
        N = Integer.parseUnsignedInt(br.readLine());
        A = new int[N];
        op = new int[4];
        max = -987654321;
        min = 987654321;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) op[i] = Integer.parseInt(st.nextToken());

        count = new int[N-1];
        input = new int[N-1];
        visit = new boolean[N-1];
        int k = 0;
        for(int i=0; i<4; i++)
            for(int j=0; j<op[i]; j++, k++) count[k] = i;
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        solve(0, 1);
        bw.flush();
    }

    static void solve(int depth, int idx) throws Exception{
        // 종료 조건
        if(depth == M){
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i=0; i<arr.length; i++) {
                bw.write(String.valueOf(arr[i] + " "));
            }
            bw.write(String.valueOf("\n"));
            bw.flush();
            return;
        }
        for(int i=idx; i<=N; i++){
            arr[depth] = i;
            solve(depth+1, i+1);
        }
    }

}

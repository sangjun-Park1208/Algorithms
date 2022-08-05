import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisit;
    static int N, M;
    static BufferedWriter bw;
    static ArrayList<Integer> A;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isVisit = new boolean[N+1];
        A = new ArrayList<>();
        solve(0);
        
    }
    static void solve(int cnt) throws Exception {
        if(cnt == M){
            for(int i=0; i<A.size(); i++) bw.write(A.get(i) + " ");
            bw.write("\n"); bw.flush();
        }
        for(int i=1; i<=N; i++){
            if(isVisit[i]) continue;
            isVisit[i] = true;
            A.add(i);
            solve(cnt+1);
            A.remove(A.size()-1);
            isVisit[i] = false;
        }
    }
}

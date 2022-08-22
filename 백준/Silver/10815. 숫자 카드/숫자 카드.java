import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {
    static Set<Integer> set;
    static BufferedWriter bw;
    static int[] find;
    static int[] ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) set.add(Integer.parseInt(st.nextToken()));
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ans = new int[M];
        for(int i=0; i<M; i++) ans[i] = solve(Integer.parseInt(st.nextToken()));
        for(int i=0; i<M; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
    }
    static int solve(int find) throws Exception{
       if (set.contains(find)) return 1;
       return 0;
    }

}

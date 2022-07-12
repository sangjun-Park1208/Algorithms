import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2812 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String input = br.readLine();
        int[] I = new int[N];
        for(int i=0; i<N; i++) { I[i] = input.charAt(i) - 48;}

        Deque<Integer> S = new ArrayDeque<>();
        int deleteCnt = 0;
        S.add(I[0]);
        for(int i=1; i<N; i++){
            while(S.size() > 0 && deleteCnt < K && S.peekLast() < I[i]){
                S.pollLast();
                deleteCnt++;
            }
            S.add(I[i]);
        }

        int[] ans = new int[N-K];
        int j=0;
        while(S.size()>0 && j<N-K){
            ans[j++] = S.pollFirst();
        }
        for(int i=0; i<N-K; i++){ bw.write(String.valueOf(ans[i])); }
        bw.flush();
    }
}

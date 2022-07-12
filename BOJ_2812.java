import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
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

        Stack<Integer> S = new Stack<>();
        int deleteCnt = 0;
        S.add(I[0]);
        for(int i=1; i<N; i++){
            if(deleteCnt == K){
                S.add(I[i]);
            }
            else{
                while(S.size() > 0 && S.peek() < I[i]){
                    S.pop();
                    deleteCnt++;
                    if(deleteCnt == K)
                        break;
                }
                S.add(I[i]);
            }
        }


        int[] ans = new int[N-K];
        int j=N-K-1;
        while(S.size() > 0){
            ans[j] = S.pop();
            j--;
        }
        for(int i=0; i<N-K; i++){ bw.write(String.valueOf(ans[i])); }
        bw.flush();
    }
}

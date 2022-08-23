import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static int ans1, ans2, N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);
        solve();
        bw.write(String.valueOf(A[ans1] + " " + A[ans2]));
        bw.flush();
    }
    static void solve(){
        int left = ans1 = 0; 
        int right = ans2 = N-1;
        int nearZero = Integer.MAX_VALUE;
        int cur;
        while(left < right){
            cur = A[left] + A[right];
            if(cur==0){
                ans1 = left;
                ans2 = right;
                return;
            }

            if(Math.abs(cur) >= nearZero) {
                if(cur<0) left++;
                if(cur>0) right--;
                continue;
            }

            nearZero = Math.abs(cur);
            ans1 = left; ans2 = right;
            if(cur<0){
                left++;
            }
            if(cur>0){
                right--;
            }

        }
    }

}

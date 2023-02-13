import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, X, left, right, ans, sum;
    static int[] input;


    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve() {
        while(left < right){
            sum = input[left] + input[right];
            if(sum < X){
                left++;
                continue;
            }
            if(sum > X){
                right--;
                continue;
            }
            ans++;
            left++;
        }
        System.out.println(ans);
    }

    static void getInput() throws IOException{
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) input[i] = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(br.readLine());
        Arrays.sort(input);
        left = 0; right = N-1;
    }
}
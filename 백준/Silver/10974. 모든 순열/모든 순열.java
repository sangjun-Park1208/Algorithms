import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static int n, r;
    static int[] input, ans;
    static boolean[] isVisit;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        r = n; // r값은 문제에 맞게 입력받아 사용.
        input = new int[n];
        ans = new int[n];
        isVisit = new boolean[n];

        for(int i=0; i<n; i++) input[i] = i+1;
        Arrays.fill(isVisit, false);
        Permutation(0); // nPr
    }

    static void Permutation(int depth) {
        /* 종료조건 */
        if(depth == r){ 
            for(int i=0; i<r; i++) System.out.print(ans[i] + " ");
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            if(!isVisit[i]){
                isVisit[i] = true;
                ans[depth] = input[i];
                Permutation(depth+1);
                isVisit[i] = false;
            }
        } 
    }

}
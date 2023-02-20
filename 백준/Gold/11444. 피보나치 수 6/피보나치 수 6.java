import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    static long N;
    static long mod = 1000000007;
    static long[][] A = {{1, 1}, {1, 0}};
    static long[][] ans;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        ans = Solve(A, N-1);
        System.out.println(ans[0][0]);
    }

    static long[][] matmul (long[][] mat1, long[][] mat2) {
        long[][] result = new long[2][2];
        result[0][0] = (mat1[0][0]*mat2[0][0] + mat1[0][1]*mat2[1][0]) % mod;
        result[0][1] = (mat1[0][0]*mat2[0][1] + mat1[0][1]*mat2[1][1]) % mod;
        result[1][0] = (mat1[1][0]*mat2[0][0] + mat1[1][1]*mat2[1][0]) % mod;
        result[1][1] = (mat1[1][0]*mat2[0][1] + mat1[1][1]*mat2[1][1]) % mod;
        return result;
    }

    static long[][] Solve(long[][] mat, long exp) {
        if(exp == 1 || exp == 0) return mat;

        long[][] ret = Solve(mat, exp/2);
        ret = matmul(ret, ret);

        if(exp%2 == 1) ret = matmul(ret, A);

        return ret;
    }

    static void getInput() throws IOException{
        N = Long.parseLong(br.readLine());
    }
}
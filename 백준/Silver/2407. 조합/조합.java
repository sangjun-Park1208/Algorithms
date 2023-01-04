import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, r, ans;
    static boolean[] isVisit;
    static BigInteger[][] DP_table;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        DP_table = new BigInteger[n+1][n+1];

        Combination();
        System.out.println(DP_table[n][r]);

    }

    static void Combination(){
        for(int i=1; i<=n; i++){
            for(int j=0; j<=i; j++){
                if(j==0 || i==j) {
                    DP_table[i][j] = BigInteger.ONE;
                    continue;
                }

                DP_table[i][j] = DP_table[i-1][j-1].add(DP_table[i-1][j]);
            }
        }
    }
}
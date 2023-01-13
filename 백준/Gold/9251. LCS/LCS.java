import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static String str1, str2;
    static int[][] DP;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve() throws IOException{
        for(int i=1; i<=str2.length(); i++){
            for(int j=1; j<=str1.length(); j++){
                if(str2.charAt(i-1) != str1.charAt(j-1)) {
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
                    continue;
                }
                DP[i][j] = DP[i-1][j-1]+1;
            }
        }
        System.out.println(DP[str2.length()][str1.length()]);
    }
    
    static void getInput() throws IOException{
        str1 = br.readLine();
        str2 = br.readLine();
        DP = new int[str2.length()+1][str1.length()+1];
    }

    static void print() {
        System.out.println("DP :");
        for(int i=0; i<=str2.length(); i++) 
            for(int j=0; j<=str1.length(); j++) 
                System.out.print(DP[i] + " ");
        System.out.println();
    }
}
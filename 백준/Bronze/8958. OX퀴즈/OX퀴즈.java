import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static String[] input;
    static int T, ans;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve() throws IOException{
        for(int i=0; i<T; i++){
            int weight = ans = 0;
            for(int j=0; j<input[i].length(); j++){
                if(input[i].charAt(j) == 'O'){
                    weight++;
                    ans += weight;
                    continue;
                }
                weight = 0;
            }
            System.out.println(ans);
        }
    }

    static void getInput() throws IOException {
        T = Integer.parseInt(br.readLine());
        input = new String[T];
        for(int i=0; i<T; i++) input[i] = br.readLine();
    }
}
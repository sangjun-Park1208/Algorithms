import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] input;
    static int sign, tmp;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve() throws IOException{
        sign = input[0] - input[1];
        for(int i=1; i<7; i++){
            tmp = input[i] - input[i+1];
            if((sign < 0 && tmp > 0) || (sign > 0 && tmp < 0)) {
                System.out.println("mixed");
                return;
            }
        }
        if(sign > 0) {
            System.out.println("descending");
            return;
        }
        System.out.println("ascending");
        return;
    }

    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        input = new int[8];
        for(int i=0; i<8; i++) input[i] = Integer.parseInt(st.nextToken());
    }
}
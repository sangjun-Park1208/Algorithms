import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static String input;
    static int t, n_x, n_o;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solve();
    }

    static void Solve() throws IOException {
        while(true){
            input = br.readLine();
            if(input.equals("end")) break;
            n_x = n_o = 0;
            for(int i=0; i<9; i++) {
                if(input.charAt(i) == 'X') n_x++;
                else if(input.charAt(i) == 'O') n_o++;
            }
            // 빙고 O 인 경우
            if(isBingo('O')){
                // O빙고와 X빙고는 동시에 나올 수 없음 (순서때문에)
                if(isBingo('X')) {
                    bw.write("invalid" + "\n");
                    continue;
                }
                // O빙고가 나왔다면 즉시 종료이므로, 개수가 같아야 함
                if(n_x != n_o){
                    bw.write("invalid" + "\n");
                    continue;
                }
                bw.write("valid" + "\n");
                continue;
            }
            // 빙고 X 인 경우
            if(isBingo('X')){
                // X빙고와 O빙고는 동시에 나올 수 없음 (순서때문에)
                if(isBingo('O')) {
                    bw.write("invalid" + "\n");
                    continue;
                }
                // X빙고가 나왔다면 즉시 종료이므로, X개수가 O개수보다 하나 많아야 함
                if(n_x != n_o+1){
                    bw.write("invalid" + "\n");
                    continue;
                }
                bw.write("valid" + "\n");
                continue;
            }
            // 빙고 없는 경우 : 반드시 꽉 채워져 있어야 함
            if(n_x == 5 && n_o == 4) {
                bw.write("valid" + "\n");
                continue;
            }

            bw.write("invalid" + "\n");
        }
        bw.flush();
    }

    static boolean isBingo(char c) {
        if(input.charAt(0) == c && input.charAt(1) == c && input.charAt(2) == c) return true;
        if(input.charAt(3) == c && input.charAt(4) == c && input.charAt(5) == c) return true;
        if(input.charAt(6) == c && input.charAt(7) == c && input.charAt(8) == c) return true;
        if(input.charAt(0) == c && input.charAt(3) == c && input.charAt(6) == c) return true;
        if(input.charAt(1) == c && input.charAt(4) == c && input.charAt(7) == c) return true;
        if(input.charAt(2) == c && input.charAt(5) == c && input.charAt(8) == c) return true;
        if(input.charAt(0) == c && input.charAt(4) == c && input.charAt(8) == c) return true;
        if(input.charAt(2) == c && input.charAt(4) == c && input.charAt(6) == c) return true;
        return false;
    }
}
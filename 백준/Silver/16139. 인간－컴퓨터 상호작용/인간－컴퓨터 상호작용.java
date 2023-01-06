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
    static String inputStr;
    static int[][] input;
    static int q;
    static int[][] list;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();
        Solve();
    }

    static void Solve() throws IOException {
        input = new int[26][inputStr.length()+1];
        for(int i=0; i<26; i++) input[i][0] = 0;
        for(int j=1; j<=inputStr.length(); j++){
            for(int i=0; i<26; i++){
                input[i][j] = input[i][j-1];
            }
            input[inputStr.charAt(j-1)-'a'][j]++;
        }

        for(int i=0; i<q; i++){
            bw.write(input[list[i][0]][list[i][2]+1] - input[list[i][0]][list[i][1]] + "\n");
        }
        bw.flush();
    }

    static void getInput() throws IOException {
        inputStr = br.readLine();
        q = Integer.parseInt(br.readLine());
        list = new int[q][3];
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            list[i][0] = st.nextToken().charAt(0) - 'a';
            list[i][1] = Integer.parseInt(st.nextToken());
            list[i][2] = Integer.parseInt(st.nextToken());
        }
    }
}
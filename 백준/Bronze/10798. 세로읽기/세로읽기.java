import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = new String[5];
        char[][] table = new char[5][15];

        for(int i=0; i<5; i++) {
            for(int j=0; j<15; j++) {
                table[i][j] = '-';
            }
        }
        for(int i=0; i<5; i++) {
            inputs[i] = br.readLine();
            for(int j=0; j<inputs[i].length(); j++) {
                table[i][j] = inputs[i].charAt(j);
            }
        }

        for(int i=0; i<15; i++) {
            for(int j=0; j<5; j++) {
                if(table[j][i] == '-') continue;
                bw.write(table[j][i]);
            }
        }

        bw.flush();
        return;
    }
    
}
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] students = new boolean[31];
        Arrays.fill(students, false);

        for(int i=0; i<28; i++) {
            students[Integer.parseInt(br.readLine())] = true;
        }

        for(int i=1; i<=30; i++) {
            if(!students[i]) bw.write(String.valueOf(i) + " ");
        }
        bw.flush();

        return;
    }

    
}
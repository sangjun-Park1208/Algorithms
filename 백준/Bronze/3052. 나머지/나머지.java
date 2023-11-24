import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> map = new HashMap<>();
        int input;
        for(int i=0; i<10; i++) {
            input = Integer.parseInt(br.readLine());
            map.put(input%42, map.getOrDefault(input%42, 1) + 1);
        }
        bw.write(String.valueOf(map.size()));
        bw.flush();
        return;
    }
}
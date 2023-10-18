import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static HashMap<Integer, Integer> map;
    static int[] target;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();

        for(int i=0; i<M; i++) {
            if(map.containsKey(target[i])) {
                bw.write(String.valueOf(map.get(target[i])) + " ");
            } else {
                bw.write(String.valueOf(0) + " ");
            }
        }
        
        bw.flush();
        return;
    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        map = new HashMap<>();
        int cur;
        for(int i=0; i<N; i++) {
            cur = Integer.parseInt(st.nextToken());
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        target = new int[M];
        for(int i=0; i<M; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
    }

}
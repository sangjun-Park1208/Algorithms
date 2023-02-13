import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, X;
    static Deque<Integer> queue;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solve();
    }

    static void Solve() throws IOException {
        N = Integer.parseInt(br.readLine());
        queue = new LinkedList<>();
        String str;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                str = st.nextToken();
                if(str.equals("push")){
                    X = Integer.parseInt(st.nextToken());
                    queue.add(X);
                    continue;
                }
                if(str.equals("front")){
                    if(queue.isEmpty()){
                        bw.write(-1 + "\n");
                        continue;
                    }
                    bw.write(queue.getFirst() + "\n");
                    continue;
                }
                if(str.equals("back")){
                    if(queue.isEmpty()){
                        bw.write(-1 + "\n");
                        continue;
                    }
                    bw.write(queue.getLast() + "\n");
                    continue;
                }
                if(str.equals("size")){
                    bw.write(queue.size() + "\n");
                    continue;
                }
                if(str.equals("empty")){
                    if(queue.isEmpty()){
                        bw.write(1 + "\n");
                        continue;
                    }
                    bw.write(0 + "\n");
                    continue;
                }
                if(str.equals("pop")){
                    if(queue.isEmpty()){
                        bw.write(-1 + "\n");
                        continue;
                    }
                    bw.write(queue.pop() + "\n");
                    continue;
                }
            }
        }
        bw.flush();
    }
}
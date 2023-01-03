import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /* Input */
    static int T, N;
    static Pair Home, Dest; // 집, 도착지
    static ArrayList<Pair> Conv; // 편의점
    static Queue<Pair> queue;
    static StringTokenizer st;
    static BufferedReader br;
    static int MIN = -32769;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            getInput();
            Solve();
        }
    }

    static void Solve() throws IOException{
        Pair p = Home;

        queue = new LinkedList<>();
        queue.add(p); // 집
        while(!queue.isEmpty()){
            p = queue.poll(); // 현재 위치
            if(Math.abs(p.i - Dest.i) + Math.abs(p.j - Dest.j) <= 1000) {
                System.out.println("happy");
                return;
            }

            Iterator<Pair> iter = Conv.iterator();
            while(iter.hasNext()){
                Pair it = iter.next();
                if(Math.abs(p.i - it.i) + Math.abs(p.j - it.j) > 1000) continue;
                queue.add(new Pair(it.i, it.j));
                iter.remove();
            }
        }
        System.out.println("sad");
        return;
    }
    static void getInput() throws IOException{
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Home = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        
        
        Conv = new ArrayList<>();
        for(int k=0; k<N; k++){
            st = new StringTokenizer(br.readLine());
            Conv.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        Dest = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

    }

    static class Pair{
        int i, j;
        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

}
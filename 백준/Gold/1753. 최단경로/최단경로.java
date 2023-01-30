import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int V, E, K, a, b, c, next, tmp;
    static int[] min;
    static ArrayList<Node>[] graph;
    static PriorityQueue<Node> pq; 
    static int INF = 987654321;
    static boolean[] selected;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static class Node {
        int index;
        int dist;
        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }

    static void Solve() {
        pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2){
                return n1.dist - n2.dist;    
            }
        });
        pq.add(new Node(K, 0));
        
        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(selected[current.index]) continue;
            selected[current.index] = true;
            
            for(int i=0; i<graph[current.index].size(); i++){
                Node next = graph[current.index].get(i);
                if(min[current.index] + next.dist < min[next.index]){
                    /* 최소 비용 갱신 */
                    min[next.index] = min[current.index] + next.dist;
                    pq.add(new Node(next.index, min[next.index]));
                }
            }
        }

        for(int i=1; i<=V; i++){
            if(i==K) {
                System.out.println(0);
                continue;    
            }
            if(min[i] == INF) {
                System.out.println("INF");
                continue;
            }
            System.out.println(min[i]);
        }
    }


    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++) graph[i] = new ArrayList<Node>();
        
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
        }
        min = new int[V+1];
        selected = new boolean[V+1];
        Arrays.fill(min, INF);
        min[K] = 0;
    }
}
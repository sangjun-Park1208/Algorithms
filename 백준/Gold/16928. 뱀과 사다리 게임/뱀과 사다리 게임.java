import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Pair> A = new ArrayList<>();
        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            A.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[101];
        visit[1] = true;
        queue.add(1);
        int ans = 0;
        int cur, curplus;
        int cnt=0;
        boolean flag;
        while(!queue.isEmpty()){
            cnt = queue.size();
            for(int s=0; s<cnt; s++){
                cur = queue.poll(); 
            
                if(cur == 100) { // 종료 조건(100 도착)
                    bw.write(String.valueOf(ans));
                    bw.flush();
                    return;
                }
                for(int i=1; i<=6; i++){
                    flag = false;
                    curplus = cur+i;
                    if(curplus > 100 || visit[curplus]){ continue; } // 합이 100을 넘어가거나, 이미 방문한 경우
                    for (Pair p : A) {
                        if(curplus == p.from){ // 사다리 or 뱀 경로를 타는 경우
                            visit[p.from] = visit[p.to] = true;
                            queue.add(p.to);
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){ // 사다리 or 뱀 경로를 타지 않은 경우
                        queue.add(curplus);
                        visit[curplus] = true;
                    }
                }
            }
            ans++;
        }

    }
    static class Pair{
        int from;
        int to;
        public Pair(int from, int to){
            this.from = from;
            this.to = to;
        }
    }

}

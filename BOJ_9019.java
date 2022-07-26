import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] TC = new int[N][2];
        boolean[] visit;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            TC[i][0] = Integer.parseInt(st.nextToken());
            TC[i][1] = Integer.parseInt(st.nextToken());
        }

        Queue<Pair> Q;
        Pair p;
        int cmp;
        for(int i=0; i<N; i++){ // TC 개수만큼 반복
            Q = new LinkedList<>();
            Q.add(new Pair(TC[i][0], new String("")));
            visit = new boolean[10000];
            while(true){ // 종료 조건 : 찾을 때 까지
                p = Q.poll();
                
                if(!visit[p.num]){
                    visit[p.num] = true;
                    cmp = D(p.num);
                    Q.add(new Pair(cmp, p.str+"D"));
                    if(cmp == TC[i][1]){ bw.write(p.str+"D"); bw.flush(); break; }

                    cmp = S(p.num);
                    Q.add(new Pair(cmp, p.str+"S"));
                    if(cmp == TC[i][1]){ bw.write(p.str+"S"); bw.flush(); break; }

                    cmp = L(p.num);
                    Q.add(new Pair(cmp, p.str+"L"));
                    if(cmp == TC[i][1]){ bw.write(p.str+"L"); bw.flush(); break; }
                
                    cmp = R(p.num);
                    Q.add(new Pair(cmp, p.str+"R"));
                    if(cmp == TC[i][1]){ bw.write(p.str+"R"); bw.flush(); break; }
                }
            }
            
            System.out.println();
        }
    }
    static int D(int n){
        return (2*n) % 10000; 
    }
    static int S(int n){
        if(n==0) return 9999;
        return n-1;
    }
    static int L(int n){
        int a = n/1000; // 천의 자리
        if(a==0) return n*10;
        return (n - a*1000)*10 + a;
    }
    static int R(int n){
        int a = n%10; // 십의 자리
        return (n-a)/10 + a*1000;
    }
    static class Pair{
        Integer num;
        String str;
        public Pair(Integer num, String str){
            this.num = num;
            this.str = str;
        }
    }
}

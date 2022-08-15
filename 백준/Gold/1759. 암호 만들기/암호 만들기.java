import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static boolean[] visit;
    static char[] input;
    static int vow_cnt, con_cnt; // 모음, 자음 개수
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Queue<Character> PQ = new PriorityQueue<>(); // 전체
        st = new StringTokenizer(br.readLine());
        char ch;
        for(int i=0; i<C; i++){
            ch = st.nextToken().charAt(0);
            PQ.add(ch);
        }

        int k=0;
        vow_cnt = con_cnt = 0;
        input = new char[C];
        visit = new boolean[C];
        while(!PQ.isEmpty()) input[k++] = PQ.poll(); // 정렬

        solve(new Node(0, ""), 0);

    }

    static void solve(Node node, int idx) throws Exception{
        if(node.depth == L) { // 종료 조건
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(String.valueOf(node.str + "\n"));
            bw.flush();
            return;
        }

        for(int i=idx; i<C; i++){
            if(!visit[i]){
                if(node.depth == L-1 && vow_cnt == 0 && !isVowel(input[i])) continue; // L-1깊이까지 모음이 없는데, 다음 문자가 모음이 아닌 경우 continue;
                if(node.depth >= L-2 && con_cnt == 0 && isVowel(input[i])) continue; // L-2 이상의 깊이까지 자음이 없는데, 다음 문자가 자음이 아닌 경우
                if(node.depth == L-1 && con_cnt <= 1 && isVowel(input[i])) continue; // L-1 깊이까지 자음이 1개 이하인데, 다음 문자가 자음이 아닌 경우
                
                if(isVowel(input[i])) vow_cnt++;
                else con_cnt++;
                visit[i] = true;
                solve(new Node(node.depth + 1, node.str + input[i]), i);

                visit[i] = false;
                if(isVowel(input[i])) vow_cnt--;
                else con_cnt--;
            }
        }

    }

    static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        return false;
    }
    static class Node{
        int depth;
        String str;
        public Node(int depth, String str){
            this.depth = depth;
            this.str = str;
        }
    }
}

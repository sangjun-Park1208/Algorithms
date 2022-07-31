import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static int[] C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        int[] g = new int[P+1];
        for(int i=1; i<=P; i++){ g[i] = Integer.parseInt(br.readLine());}
        C = new int[G+1];
        for(int i=0; i<=G; i++){ C[i] = -1; } // 초기화

        int ans = 0;
        for(int i=1; i<=G; i++){
            if(find(g[i]) == -10){ // 종료 조건 : 더 이상 도킹할 게이트가 없는 경우
                break;
            }
            ans++;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int find(int idx){
        if(idx == 0){ // 마지막 게이트까지 도킹된 상태 : 종료 조건
            return -10;
        }
        if(C[idx] < 0){ // 비어 있는 경우 : 도킹 진행 (종료 조건)
            return C[idx] = idx-1; // 바로 앞 인덱스로 마킹
        }
        else{ // 이미 도킹된 경우 : 비어 있는 인덱스까지 가서 채우고(위 if경우), 그 앞 인덱스를 리턴해서 저장 : 한 번에 접근할 수 있게
            return C[idx] = find(C[idx]);
        }        
    }
}

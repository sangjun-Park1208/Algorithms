import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[][] MAP;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        MAP = new int[10][10];
        for(int i=1; i<=9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=9; j++){ MAP[i][j] = Integer.parseInt(st.nextToken());}
        }

        bt();
        for(int i=1; i<=9; i++){
            for(int j=1; j<=9; j++){ bw.write(String.valueOf(MAP[i][j] + " "));}
            bw.write("\n");
            bw.flush();
        }
    }
    static boolean bt(){
        if(isFull()) return true;
        for(int i=1; i<=9; i++){
            for(int j=1; j<=9; j++){
                if(MAP[i][j] == 0){
                    for(int k=1; k<=9; k++){
                        if(isValid(i, j, k)){
                            MAP[i][j] = k;
                            if(bt()) return true;
                        }
                    }
                    MAP[i][j] = 0;
                    return false; // 해당 칸에 적합한 수가 없는 경우
                }
            }
        }
        return false;
    }
    static boolean isValid(int r, int c, int val){
        for(int i=1; i<=9; i++){ // 행 검사
            if(c==i) continue;
            if(MAP[r][i] == val) return false;
        }
        for(int i=1; i<=9; i++){ // 열 검사
            if(r==i) continue;
            if(MAP[i][c] == val) return false;
        }
        for(int i=(r-1)/3*3+1; i<=(r-1)/3*3+3; i++){ // 3*3 검사
            for(int j=(c-1)/3*3+1; j<=(c-1)/3*3+3; j++){
                if(c==i && r==j) continue;
                if(MAP[i][j] == val) return false;
            }
        }
        return true;
    }
    static boolean isFull(){
        for(int i=1; i<=9; i++){
            for(int j=1; j<=9; j++){
                if(MAP[i][j] == 0) return false;
            }
        }
        return true;
    }
}

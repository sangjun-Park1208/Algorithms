import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isPos; // 알파벳이 지나갈 수 있는지 체크 (false 초기화)
    static int ans;
    static char[][] MAP;
    static int[] move_i = new int[4];
    static int[] move_j = new int[4];
    static int R, C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // R(row) : 세로
        C = Integer.parseInt(st.nextToken()); // C(column) : 가로
        isPos = new boolean[27];
        MAP = new char[R+1][C+1];
        String str;
        move_i[0] = -1;
        move_i[1] = 1;
        move_i[2] = move_i[3] = 0;
        move_j[2] = -1;
        move_j[3] = 1;
        move_j[0] = move_j[1] = 0;
        for(int i=0; i<26; i++){ isPos[i] = true; } // true 초기화

        for(int i=1; i<=R; i++){
            str = new String(br.readLine());
            for(int j=1; j<=C; j++){ MAP[i][j] = str.charAt(j-1); }
        }

        ans = 0;
        isPos[MAP[1][1]-'A'] = false;
        solve(1, 1, 1);
        bw.write(String.valueOf(ans));
        bw.flush();
    }
    static void solve(int i, int j, int depth){
        ans = Math.max(ans, depth);
        int next_i, next_j;
        for(int k=0; k<4; k++){
            next_i = i+move_i[k];
            next_j = j+move_j[k];
            if(next_i == 0 || next_j == 0 || next_i > R || next_j > C) continue;
            
            if(isPos[MAP[next_i][next_j]-'A']){
                isPos[MAP[next_i][next_j]-'A'] = false;
                solve(next_i, next_j, depth+1);
                isPos[MAP[next_i][next_j]-'A'] = true;
            }
        }
    }
}

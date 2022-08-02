import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[][] MAP, isVisit;
    static int ans, M, N;
    static int[] move_i = {-1, 1, 0, 0};
    static int[] move_j = {0, 0, -1, 1}; // 상,하,좌,우
    static int[][] DP;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int INF = 10001; // 항상 가장 큰 수
        ans = 0;

        MAP = new int[M+2][N+2];
        isVisit = new int[M+2][N+2];

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){ MAP[i][j] = Integer.parseInt(st.nextToken()); isVisit[i][j] = 0;}
        }
        for(int i=0; i<M+2; i++){MAP[i][0] = MAP[i][N+1] = INF; isVisit[i][0] = isVisit[i][N+1] = 1;}
        for(int i=0; i<N+2; i++){MAP[0][i] = MAP[M+1][i] = INF; isVisit[0][i] = isVisit[M+1][i] = 1;}
        isVisit[1][1] = 1; // 출발지점은 이미 방문한 것으로 처리

        DP = new int[M+2][N+2];
        for(int i=0; i<M+2; i++){
            for(int j=0; j<N+2; j++){
                DP[i][j] = -1;
            }
        }
        // DP[M][N] = 1;
        // int next_i, next_j;
        // for(int i=1; i<=M; i++){
        //     for(int j=1; j<=N; j++){
        //         for(int k=0; k<4; k++){
        //             next_i = i+move_i[k]; next_j = j+move_j[k];
        //             if(isVisit[next_i][next_j] == 0 && MAP[i][j] > MAP[next_i][next_j]){
        //                 DP[next_i][next_j] += DP[i][j];
        //             }
        //         }
        //     }
        // }
        solve(1,1);
        // debug();
        bw.write(String.valueOf(DP[1][1]));
        // bw.write(String.valueOf(ans));
        bw.flush();
    }
    static int solve(int i, int j){
        if(i == M && j == N) {DP[i][j]++; return 1;}
        if(DP[i][j] != -1) {return DP[i][j];}
        int next_i, next_j;
        DP[i][j] = 0;
        for(int k=0; k<4; k++){
            next_i = i+move_i[k]; next_j = j+move_j[k];
            if(isVisit[next_i][next_j] == 0 && MAP[i][j] > MAP[next_i][next_j]){ // 다음 좌표로 이동할 수 있다면
                // if(DP[next_i][next_j] != 0) {DP[i][j] += DP[next_i][next_j]; continue;}
                isVisit[next_i][next_j] = 1;
                DP[i][j] += solve(next_i, next_j);
                isVisit[next_i][next_j] = 0;
                // debug();
            }
        }
        return DP[i][j];

    }

    static void debug(){
        for(int i=1; i<=M; i++){
            for(int j=1; j<=N; j++){
                System.out.print(DP[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }
}

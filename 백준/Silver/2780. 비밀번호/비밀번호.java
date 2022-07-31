import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int s=0; s<T; s++){
            int N = Integer.parseInt(br.readLine());
            int[][] D = new int[N+1][10];
            int sum = 0;

            for (int k = 0; k < 10; k++) {
                D[1][k] = 1;
            }
            if(N==1){
                bw.write(String.valueOf(10) + "\n");
                continue;
            }

            for (int i = 2; i <= N; i++) {
                for (int j = 0; j < 10; j++) {
                    switch (j) {
                        case 0:
                            D[i][j] = D[i - 1][7];
                            break;
                        case 1:
                            D[i][j] = D[i - 1][2] + D[i - 1][4];
                            break;
                        case 2:
                            D[i][j] = D[i - 1][1] + D[i - 1][3] + D[i - 1][5];
                            break;
                        case 3:
                            D[i][j] = D[i - 1][2] + D[i - 1][6];
                            break;
                        case 4:
                            D[i][j] = D[i - 1][1] + D[i - 1][5] + D[i - 1][7];
                            break;
                        case 5:
                            D[i][j] = D[i - 1][2] + D[i - 1][4] + D[i - 1][6] + D[i - 1][8];
                            break;
                        case 6:
                            D[i][j] = D[i - 1][3] + D[i - 1][5] + D[i - 1][9];
                            break;
                        case 7:
                            D[i][j] = D[i - 1][0] + D[i - 1][4] + D[i - 1][8];
                            break;
                        case 8:
                            D[i][j] = D[i - 1][5] + D[i - 1][7] + D[i - 1][9];
                            break;
                        case 9:
                            D[i][j] = D[i - 1][6] + D[i - 1][8];
                            break;
                    }
                    D[i][j] = D[i][j]  % 1234567;
                    
                }
                
            }
            sum += D[N][0] + D[N][1] + D[N][2] + D[N][3] + D[N][4] + D[N][5] + D[N][6] + D[N][7]+ D[N][8] + D[N][9];
            sum %= 1234567;

            bw.write(String.valueOf(sum) + "\n");
        }
        bw.flush();

    }
}

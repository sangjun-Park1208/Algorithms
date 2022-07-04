import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1931 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] T = new int[N][2];
        int C=1;

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i][0] = Integer.parseInt(st.nextToken());
            T[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(T, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            } 
        });

        int[] S = new int[2];
        S = T[0];
        for(int i=0; i<N-1; i++){
            if(S[1] <= T[i+1][0]){
                C++;
                S = T[i+1];
            }
        }

        bw.write(String.valueOf(C));
        bw.flush();

    }
}

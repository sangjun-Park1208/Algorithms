import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2751 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> A = new ArrayList<>();
        for(int i=0; i<N; i++){ A.add(Integer.parseInt(br.readLine())); }
        Collections.sort(A);
        for(int i : A){
            bw.write(String.valueOf(i)+'\n');
        }
        bw.flush();
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] B = new int[N];
        for(int i=0; i<N; i++){ B[i] = Integer.parseInt(br.readLine()); }

        // Arrays.sort(B);

        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            PQ.add(B[i]);
        }
        int sum = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        while(PQ.size() != 1){
            tmp1 = PQ.poll();
            tmp2 = PQ.poll();
            sum += tmp1 +tmp2;
            PQ.add(tmp1 + tmp2);     
        }
        bw.write(String.valueOf(sum));
        bw.flush();


    }
}

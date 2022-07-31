import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> A_PQ = new PriorityQueue<>();
        PriorityQueue<Integer> B_PQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++){
            A_PQ.add(Integer.parseInt(st1.nextToken()));
            B_PQ.add(Integer.parseInt(st2.nextToken()));
        }

        int A, B;
        int sum = 0;
        for(int i=0; i<N; i++){
            A = A_PQ.poll();
            B = B_PQ.poll();
            sum += A*B;
        }

        bw.write(String.valueOf(sum));
        bw.flush();

    }
}

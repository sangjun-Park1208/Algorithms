import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] Seq = new int[N];
        for(int i=0; i<N; i++){
            Seq[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(Seq);

        int sum = 0;
        int n = 0;
        int r = N-1;
        for(; n<r; n+=2){ // 음수 중 짝수로 묶일 수 있는 것들의 곱셈 후 누적
            if(Seq[n]<1 && Seq[n+1]<1)
                sum += Seq[n] * Seq[n+1];
            else
                break;
        }

        for(; r>0; r-=2){ // 양수 중 짝수로 묶일 수 있는 것들의 곱셈 후 누적
            if(Seq[r]>1 && Seq[r-1]>1)
                sum += Seq[r] * Seq[r-1];
            else   
                break;
        }

        for(; n<=r; n++){
            sum+=Seq[n];
        }
        bw.write(String.valueOf(sum));
        bw.flush();




    }
}

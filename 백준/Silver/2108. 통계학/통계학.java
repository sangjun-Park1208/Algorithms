import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] input = new int[N];
        double sum = 0;
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(br.readLine());
            sum += input[i];
        }

        long avg = Math.round(sum / N);
        
        Arrays.sort(input);
        int med = input[input.length/2];
        int max = -4001;
        int cnt[] = new int[8001];
        int mode;
        ArrayList<Integer> AL = new ArrayList<>();


        for(int i : input){
            if(i < 0){
                cnt[Math.abs(i)+4000]++;
            }
            else
                cnt[i]++;
        }

		for(int i=0;i<cnt.length;i++) {
			if(cnt[i]!=0 && cnt[i]>max)		
				max = cnt[i];
		}

        for(int i=0; i<cnt.length; i++){
            int x = i;
            if(cnt[i] == max){
                if(i > 4000){
                    x -= 4000;
                    x *= -1;
                    AL.add(x);
                }
                else
                    AL.add(i);
            }
        }
        Collections.sort(AL);
        if(AL.size() > 1)
            mode = AL.get(1);
        else   
            mode = AL.get(0);

        int range = input[N-1] - input[0];
        
        bw.write(String.valueOf(avg + "\n" + med + "\n" + mode + "\n" + range));
        bw.flush();

    }
}

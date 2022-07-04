import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2839 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int five = 0;
        int three = 0;
        int cur = N;

        while(cur > 0){
            if(cur >= 5){
                if(cur%5 != 0 && cur%3 == 0){
                    three++;
                    cur -= 3;
                }
                else{
                    five++;
                    cur -= 5;
                }
            }
            else if(cur >= 3 || cur % 3 == 0){
                three++;
                cur -= 3;
            }
            else{
                bw.write(String.valueOf(-1));
                bw.flush();
                return;
            }
        }
        bw.write(String.valueOf(five + three));
        bw.flush();

    }
}

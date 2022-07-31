import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Integer> D;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        D = new ArrayList<>();
        D.add(0);
        int input = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            input = Integer.parseInt(st.nextToken());
            for(int j=0; j<D.size(); j++){
                if(D.get(j) >= input){
                    D.set(j, input);
                    break;
                }
                if(j == D.size()-1){
                    D.add(input);
                    break;
                }
            }
        }
        bw.write(String.valueOf(D.size()-1));
        bw.flush();
    }
}

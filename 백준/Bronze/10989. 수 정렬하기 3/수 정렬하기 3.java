import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int[] Count;
    public static void main(String[] args) throws IOException{
        getInput();
        Solve();
    }
    
    static void getInput() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        N = Integer.parseInt(br.readLine());
        Count = new int[10001];

        for(int i=0; i<N; i++) Count[Integer.parseInt(br.readLine())]++;
    }

    static void Solve() throws IOException{
        for(int i=1; i<=10000; i++)
            while(Count[i]-- > 0) bw.write(i+"\n");
        bw.flush();
    }
}
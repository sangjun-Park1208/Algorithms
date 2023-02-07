import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuffer input, boom, stackStr;
    static int boomStrLength;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        Solve();
    }

    static void Solve(){
        for(int i=0; i<input.toString().length(); i++){
            if(stackStr.length() < boomStrLength) {
                stackStr.append(input.toString().charAt(i));
                continue;
            }
            
            if(stackStr.substring(stackStr.length()-boomStrLength).equals(boom.toString())) {
                stackStr.delete(stackStr.length()-boomStrLength, stackStr.length());
            }
            stackStr.append(input.toString().charAt(i));
        }

        while(stackStr.length() >= boomStrLength && stackStr.substring(stackStr.length()-boomStrLength).equals(boom.toString())){
            stackStr.delete(stackStr.length()-boomStrLength, stackStr.length());
        }

        if(stackStr.length() == 0) {
            System.out.println("FRULA");
            return;
        }

        System.out.println(stackStr);
    }

    static void getInput() throws IOException{
        input = new StringBuffer();
        boom = new StringBuffer();
        stackStr = new StringBuffer();
        input.append(br.readLine());
        boom.append(br.readLine());
        boomStrLength = boom.toString().length();
    }
}
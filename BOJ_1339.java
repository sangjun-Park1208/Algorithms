import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1339 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] W = new String[N];
        int[] alphabet = new int[26]; // A ~ Z
        int digit = 1;

        for(int i=0; i<N; i++){ // 각 단어 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            W[i] = st.nextToken();
        }

        // 입력받은 단어의 각 문자 개수 카운팅
        for(int i=0; i<N; i++){
            digit = (int)Math.pow(10, W[i].length()-1);
            for(int j=0; j<W[i].length(); j++){
                alphabet[W[i].charAt(j) - 65] += digit;
                digit /= 10;                
            }
        }

        // 문자를 자릿수 단위 -> 정렬
        Arrays.sort(alphabet);
        int temp=0;
        for(int i=0; i<alphabet.length/2; i++){
            temp = alphabet[i];
            alphabet[i] = alphabet[alphabet.length-i-1];
            alphabet[alphabet.length-i-1] = temp;
        }
        int sum = 0;
        int tmp = 9;
        for(int i=0; i<26; i++, tmp--){
            if(alphabet[i] == 0)
                break;
            sum += tmp*alphabet[i];
        }

        bw.write(String.valueOf(sum));
        bw.flush();


    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, left, right, ans, sum, sqrt, primeCnt;
    static boolean[] isprime;
    static int[] primeList;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        getInput();
        getPrimeList();
        getCumulateSum();
        Solve();
    }

    static void Solve() {
        while(right <= primeCnt){
            if(left == right){
                right++;
                continue;
            }

            sum = primeList[right] - primeList[left];
            if(sum < N){
                right++;
                continue;
            }
            if(sum > N){
                left++;
                continue;
            }
            ans++;
            left++;
        }
        
        System.out.println(ans);
    }

    static void getInput() throws IOException{
        N = Integer.parseInt(br.readLine());
        isprime = new boolean[N+1];
        Arrays.fill(isprime, true);
        sqrt = (int)Math.sqrt(N) + 1;
    }

    static void getPrimeList(){
        int j;
        primeCnt = 0;
        for(int i=2; i<sqrt; i++){
            if(isprime[i]){
                j = 2;
                while(i*j <= N){
                    isprime[i*j] = false;
                    j++;
                }
            }
        }
        
        for(int i=2; i<=N; i++)
            if(isprime[i]) primeCnt++;
        
        int k=1;
        primeList = new int[primeCnt+1];
        for(int i=2; i<=N; i++)
            if(isprime[i]) primeList[k++] = i;
        
        left = 0; 
        right = 1;
    }

    static void getCumulateSum(){
        int tmp = 0;
        for(int i=1; i<=primeCnt; i++){
            tmp += primeList[i];
            primeList[i] = tmp;
        }
    }
}
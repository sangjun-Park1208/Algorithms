import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static int truthNum; // 진실을 아는 사람의 수
    static int[] truth; // 진실을 아는 사람들의 번호
    static ArrayList<int[]> parties; // 파티
    static int[] people;
    static int answer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();

        for(int[] party : parties) {
            for(int i=0; i<party.length; i++) {
                for(int j=i+1; j<party.length; j++){
                    makeUnion(party[i], party[j]);
                }
            }
        }

        if(truthNum == 0) {
            bw.write(String.valueOf(M));
            bw.flush();
            return;
        }

        answer = 0;
        boolean flag;
        for(int[] party : parties) { // 모든 파티 순회
            flag = false;
            for(int p=0; p<party.length; p++) { // 각 파티 내에서
                for(int t=0; t<truth.length; t++) {
                    if(findParent(party[p]) == findParent(truth[t])) { // 진실을 아는 사람의 root가 해당 파티원의 root가 같다면 (과장해서 말할 수 없음)
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    answer++;
                    break;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        
        return;
    }

    static boolean makeUnion(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if(x == y) return false;

        if(x <= y) people[y] = x;
        else people[x] = y;

        return true;
    }

    static int findParent(int x) {
        if(people[x] == x) return x;
        return findParent(people[x]);
    }

    static void getInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        people = new int[N+1];
        for(int i=1; i<=N; i++) {
            people[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        truthNum = Integer.parseInt(st.nextToken());
        truth = new int[truthNum];
        for(int i=0; i<truthNum; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        parties = new ArrayList<>();
        int[] party;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            party = new int[Integer.parseInt(st.nextToken())];
            for(int k=0; k<party.length; k++) {
                party[k] = Integer.parseInt(st.nextToken());
            }
            parties.add(party);
        }
    }
}
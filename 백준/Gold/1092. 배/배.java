import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] crane = new Integer[N];
        for(int i=0; i<N; i++){ crane[i] = Integer.parseInt(st.nextToken()); }
        Arrays.sort(crane, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
            
        });

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        for(int i=0; i<M; i++){ box.add(Integer.parseInt(st.nextToken()));}
        Collections.sort(box, Collections.reverseOrder());
        
        int ans = 0;
        int cnt;
        if(crane[0] < box.get(0)) {
            bw.write(String.valueOf(-1));
            bw.flush();
            return;
        }
        while(box.size() > 0){
            cnt = 0;
            for(int i=0; i<N;){
                if(box.size() == cnt) break;
                if(crane[i] < box.get(cnt)){cnt++;continue;}
                box.remove(cnt);
                i++;
            }
            ans++;
        }
        bw.write(String.valueOf(ans));
        bw.flush();

    }
}

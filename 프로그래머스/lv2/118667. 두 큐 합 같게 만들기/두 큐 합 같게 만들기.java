import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

class Solution {
    public long solution(int[] queue1, int[] queue2) {
        long answer = -2;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        long q1_sum, q2_sum;
        long cnt;
        q1_sum = q2_sum = cnt = 0;
        long tmp = 0;
        for(int i=0; i<queue1.length; i++){
            q1.add(Long.parseLong(String.valueOf(queue1[i])));
            q1_sum += queue1[i];
            q2.add(Long.parseLong(String.valueOf(queue2[i])));
            q2_sum += queue2[i];
        }

        while(cnt<600000){
            if(q1.isEmpty() || q2.isEmpty()){
                return -1;
            }
            if(q1_sum < q2_sum){
                tmp = q2.poll();
                q1.add(tmp);
                q1_sum += tmp;
                q2_sum -= tmp;
                cnt++;
            }
            else if(q1_sum > q2_sum){
                tmp = q1.poll();
                q2.add(tmp);
                q1_sum -= tmp;
                q2_sum += tmp;
                cnt++;   
            }
            if(q1_sum == q2_sum){
                return answer = cnt;
            }
        }
        
        
        return -1;
    }
}
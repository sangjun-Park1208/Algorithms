import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) {
            PQ.add(scoville[i]);
        }
        
        int first, second, mix;
        while(PQ.size() > 0) {
            if(PQ.peek() >= K) { // 모든 음식이 K이상인 경우: 종료
                return answer;
            }
            
            if(PQ.size() == 1) { // 1개만 남은 경우
                return -1;
            }
            
            first = PQ.poll();
            second = PQ.poll();
            mix = first + second*2;
            PQ.add(mix);
            answer++;
            
        }
        answer = -1;
        
        return answer;
    }
}
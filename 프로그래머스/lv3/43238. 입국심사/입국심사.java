import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        // 이분탐색 최소, 최대 설정
        long left, right, mid;
        left = 0;
        right = times[times.length-1] * (long)n;
        long complete;
        while(left <= right) {
            complete = 0;  // 모든 사람이 검사 완료하기까지의 시간
            mid = (left + right) / 2;
            for(int i=0; i<times.length; i++) {
                complete += mid / times[i];
            }
            
            if(complete < n) { // 모두를 검사하지는 못한 경우
                left = mid + 1;
            } else { // 모두 검사했으나 시간이 더 남을수도 있는 경우
                right = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}
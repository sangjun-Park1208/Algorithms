import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int h;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            h = citations.length - i;
            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}
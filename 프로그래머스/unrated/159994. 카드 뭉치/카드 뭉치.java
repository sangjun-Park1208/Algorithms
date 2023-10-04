import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int c1, c2, g;
        c1 = c2 = g = 0;
                
        while(true) {
            
            // 종료조건1: 만들 수 있는 경우
            if(g == goal.length) { 
                answer = "Yes";
                break;
            }
            
            // cards1에서 찾은 경우
            if(c1 < cards1.length && cards1[c1].equals(goal[g])) {
                c1++;
                g++;
                continue;
            }
            
            // cards2에서 찾은 경우
            if(c2 < cards2.length && cards2[c2].equals(goal[g])) {
                c2++;
                g++;
                continue;
            }
            
            answer = "No";
            break;
            
        }
        return answer;
    }
}
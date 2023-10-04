import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] remains = new boolean[n];
        for(int i=0; i<section.length; i++) {
            remains[section[i]-1] = true;
        }
        
        int left, right;
        left = 0;
        right = n-1;
        
        while(left <= right) { // 0, 3
            if(remains[left]) {
                for(int i=left; i<n && i<left+m; i++) {
                    remains[i] = false;
                }
                answer++;
                
                if(left+m >= n) break;
                left += m;
            } else {
                left++;
            }
            
            if(remains[right]) {
                for(int i=right; i>=0 && i>right-m; i--) {
                    remains[i] = false;
                }
                answer++;
                if(right-m <= 0) break;
                right -= m;
            } else {
                right--;
            }
        }
        
        
        return answer;
    }
}
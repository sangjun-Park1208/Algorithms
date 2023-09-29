import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        
        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
                
        if(nums.length/2 < map.size()) answer = (nums.length / 2);
        else answer = map.size();

        return answer;
    }
}
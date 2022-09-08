class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        return answer = dfs(numbers, 0, target, 0, 0);
    }
    int dfs(int[] numbers, int idx, int target, int sum, int ans){

        if(idx == numbers.length){
            if(sum == target){
                return ans+1;
            }
            return 0;
            
        }

        int ret = 0;
        ret += dfs(numbers, idx+1, target, sum+numbers[idx], ans);
        ret += dfs(numbers, idx+1, target, sum-numbers[idx], ans);
        return ret + ans;
    }
}
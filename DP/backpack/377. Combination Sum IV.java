518是求组合！377是求排列！

两个for loop的先后有说法 和 377 一起看 


class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int j = 0; j <= target; j++){
            for(int i = 0; i < nums.length; i++){
                if(j >= nums[i]){
                    dp[j] = dp[j] + dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
}

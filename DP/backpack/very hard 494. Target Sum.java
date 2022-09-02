class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
        }
        if((sum+target)%2 != 0){
            return 0;
        }
        if(Math.abs(target) > sum){
            return 0;
        }
        int length = (sum + target)/2;
        int[] dp = new int[length+1];
        dp[0] = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = length; j >= nums[i]; j--){
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[length];
    }
} 

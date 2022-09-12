class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length <= 1){
            return 1;
        }
        int[] dp = new int[nums.length];
        int result = 0;
        for(int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }
            if(dp[i] > result){
                result = dp[i];
            }
        }
        return result + 1;
        
    }
}

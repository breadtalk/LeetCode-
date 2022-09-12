这题还有贪心算法 但是dp算法更好理解

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        int result = Integer.MIN_VALUE;
        for(int i = 1; i <= nums.length; i++){
            dp[i] = Math.max(dp[i-1]+nums[i-1], nums[i-1]);
            if(dp[i] > result){
                result = dp[i];
            }
        }
        return result;
    }
}

分成左右两个子集 
左-右 = target 
左+右 = sum
如果target 绝对值大于sum无解
target+sum除不了2 无解
剩下要求多少种可以凑成 （sum+target）/2的方法
length 就是记录sum 
dp里的数字记录能到某个length有多少种方法




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

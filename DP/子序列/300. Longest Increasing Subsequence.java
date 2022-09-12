取每一小段 longest number 然后如果后面的数字大于这个数字就回到这个数字加1 dp[i] = dp[j] + 1
最长子序列不一定contain last number 所有要有个变量随时记录到每一段的最长子序列
  
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int[] dp = new int[nums.length];
        int longest = 0;
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
        }
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
               if(nums[i] > nums[j]){
                   dp[i] = Math.max(dp[i], dp[j]+1);
               } 
            }
            if(dp[i] > longest){
                longest = dp[i];
            }
        }
        return longest;
    }
}
  

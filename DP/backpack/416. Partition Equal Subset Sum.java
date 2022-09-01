和01背包一样的做法

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2 !=0){
            return false;
        }
        int halfSum = sum/2;
        int[][] dp = new int[nums.length][halfSum+1];
        
        for(int i = 0; i < nums.length; i++){
            dp[i][0] = 0;
        }
        for(int j = 1; j < halfSum+1; j++){    
            if(j < nums[0]){
                dp[0][j] = dp[0][j-1];
            }
            else{
                dp[0][j] = nums[0];
            }
        }
        
        for(int j = 1; j < halfSum+1; j++){
            for(int i = 1; i < nums.length; i++){
                if(j < nums[i]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]] + nums[i]);
                }
            }
        }

        
       for(int i = 0; i< nums.length; i++){
           for(int j = 0; j <= halfSum; j++){
               System.out.print(dp[i][j]);
           }
           System.out.println();
       } 

        
        
        
        
       return dp[nums.length-1][halfSum] == halfSum;
        
    }
}

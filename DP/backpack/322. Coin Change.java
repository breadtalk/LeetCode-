class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        if(coins.length == 1 && coins[0] > amount){
            return -1;
        }
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j >= coins[i] && dp[j-coins[i]]!=0){
                    if(dp[j] == 0){
                        dp[j] = dp[j-coins[i]]+1;
                    }
                    else{
                        dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                    }
                }
            }
        }
        

        
        if(dp[amount] == 0){
            return -1;
        }
        else{
            return dp[amount]-1;
        }
    }
    
}

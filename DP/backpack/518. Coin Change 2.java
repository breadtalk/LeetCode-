第一种方法用二维数组写比较好理解但是要先定义好第一个column
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++){
            dp[i][0] = 1; 
        }
        for(int j= coins[0]; j <= amount; j++){
            if(j == coins[0]){
                dp[0][j] = 1;
            }
            else{
                dp[0][j] = dp[0][j-coins[0]];
            }
        }
        
        for(int i = 1; i <coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j >= coins[i]){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                }
                else{
                   dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        /*for(int i = 0; i < dp.length; i++){
            for(int j = 0; j <dp[0].length; j++){
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }*/

        return dp[coins.length-1][amount];
    }
}





用一维数组写更简单
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 0; i <coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }
        
        return dp[amount];
    }
}

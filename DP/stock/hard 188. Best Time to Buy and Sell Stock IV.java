class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int[][] dp = new int[prices.length][2*k + 1];
        for(int i = 1; i < 2 * k; i = i + 2){
            dp[0][i] = -1 * prices[0];
        }
        for(int i = 1; i < prices.length; i++){
            for(int j = 1; j < 2 * k; j = j + 2){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] - prices[i]);
                dp[i][j+1] = Math.max(dp[i-1][j+1], dp[i-1][j] + prices[i]);
            }
        }
        return dp[prices.length-1][2 * k];
    }
}

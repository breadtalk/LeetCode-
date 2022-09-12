每一天都有五种状态
0 - 不买也不卖
1 - 买 
2 - 卖
3 - 买
4 - 卖

然后初始化
dp[0][0] = 0
dp[0][1] = -prices[0]
dp[0][2] = 0  ------------最差收益就是0 小于0 肯定就不卖了
dp[0][3] = -prices[0]
dp[0][4] = 0   -----------同2

class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0; 
        dp[0][1] = -1 * prices[0];
        dp[0][2] = 0;
        dp[0][3] = -1 * prices[0];
        dp[0][4] = 0;
        for(int i = 1; i < prices.length; i++){
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
            dp[i][2] = Math.max(dp[i-1][1] + prices[i], dp[i-1][2]);
            dp[i][3] = Math.max(dp[i-1][2] - prices[i], dp[i-1][3]);
            dp[i][4] = Math.max(dp[i-1][3] + prices[i], dp[i-1][4]);
        }
        return dp[prices.length-1][4];
    }
}

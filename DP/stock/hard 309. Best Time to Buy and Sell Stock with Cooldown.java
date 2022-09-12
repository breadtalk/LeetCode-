一共有四个状态
状态0 买入的状态 三种情况 a. 持续前一天的买入状态 b.在状态1的情况下买入 c.冷冻期过后状态3的情况下买入
状态1 卖出 两种情况 a. 延续前一天的卖出状态 b. 前一天是卖出冷冻期 这两种状态都可以买入 
状态2 卖出 只有一种情况 在前一天买入状态的情况下今天卖出 这种状态 后一天不能买入 后一天只能是冷冻期
状态3 冷冻期 前一天是上一层状态2

初始化dp[0][0] -prices[0] 其他都是卖出状态最少为0 负数不必卖出

最后profit取后三个状态最大值

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -1 * prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1]-prices[i], dp[i-1][3]-prices[i]));
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
            dp[i][2] = dp[i-1][0] + prices[i];
            dp[i][3] = dp[i-1][2];
        }
        

        
        return Math.max(dp[prices.length-1][3],Math.max(dp[prices.length-1][1], dp[prices.length-1][2]));
    }
}

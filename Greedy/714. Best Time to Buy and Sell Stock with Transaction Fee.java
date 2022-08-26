有fee
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int buyPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < buyPrice){                                   //如果当前价钱小于buyprice的话 重新卖
                buyPrice = prices[i];
            }
            else if(prices[i] > buyPrice + fee){
                profit = profit + prices[i] - buyPrice - fee;
                buyPrice = prices[i] - fee;                              //最关键的一步 重新update buyPrice 保证不重复计算profit并且不重复减fee
            }
            else{                                                        //当前price大于buyprice 但是并没有赚钱 跳过 等待要么更低价钱买入 要么等涨上去收profit
                continue;
            }
        }
        return profit;
    }
}

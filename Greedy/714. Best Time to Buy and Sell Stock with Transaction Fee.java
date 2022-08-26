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
            else{                                                        //当前price大于buyprice 但是并没有赚钱 跳过 等待要么更低价钱买入 要么等涨上去收profit从代码中
                                                                          //可以看出对情况一的操作，因为如果还在收获利润的区间里，表示并不是真正的卖出，
                                                                          //而计算利润每次都要减去手续费，所以要让minPrice = prices[i] - fee;，
                                                                          //这样在明天收获利润的时候，才不会多减一次手续费！
                continue;
            }
        }
        return profit;
    }
}

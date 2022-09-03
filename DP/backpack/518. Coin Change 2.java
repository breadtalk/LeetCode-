518是求组合！377是求排列！

两个for loop的先后有说法 和 377 一起看 

本题是求凑出来的方案个数，且每个方案个数是为组合数。

那么本题，两个for循环的先后顺序可就有说法了。

我们先来看 外层for循环遍历物品（钱币），内层for遍历背包（金钱总额）的情况。

代码如下：

for (int i = 0; i < coins.size(); i++) { // 遍历物品
    for (int j = coins[i]; j <= amount; j++) { // 遍历背包容量
        dp[j] += dp[j - coins[i]];
    }
}
假设：coins[0] = 1，coins[1] = 5。

那么就是先把1加入计算，然后再把5加入计算，得到的方法数量只有{1, 5}这种情况。而不会出现{5, 1}的情况。

所以这种遍历顺序中dp[j]里计算的是组合数！

如果把两个for交换顺序，代码如下：

for (int j = 0; j <= amount; j++) { // 遍历背包容量
    for (int i = 0; i < coins.size(); i++) { // 遍历物品
        if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]];
    }
}
背包容量的每一个值，都是经过 1 和 5 的计算，包含了{1, 5} 和 {5, 1}两种情况。

此时dp[j]里算出来的就是排列数！





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

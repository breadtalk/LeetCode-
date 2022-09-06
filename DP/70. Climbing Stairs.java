每一格楼梯所需要的是
走两格有两种办法 所以是(n-2)*2  再加上走一格的方法 （n-1)-(n-2)


还有一种想法
只有两种方法到到n
n-1再走一格
或者n-2再走两格

所以就是n-1 加上 n-2 不需要记录整个数组 只需要前2位就可以了

第三种办法用完全背包的方法来做这一题
  
  
  class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int index = 3; index <= n; index++){
            dp[index] = (dp[index-1] - dp[index-2]) + dp[index-2]*2;
        }
        return dp[n];
    }
}


class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int[] dp = new int[4];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int index = 3; index <= n; index++){
            int temp = dp[2] + dp[1];
            dp[1] = dp[2];
            dp[2] = temp;
        }
        return dp[2];
    }
}



class Solution {
    public int climbStairs(int n) {
        int[] stairs = {1, 2};
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < stairs.length; j++){
                if(i >= stairs[j]){
                    dp[i] = dp[i] + dp[i-stairs[j]];
                }
            }
        }
        return dp[n];
    }
}

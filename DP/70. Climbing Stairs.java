每一格楼梯所需要的是
走两格有两种办法 所以是(n-2)*2  再加上走一格的方法 （n-1)-(n-2)


还有一种想法
只有两种方法到到n
n-1再走一格
或者n-2再走两格

所以就是n-1 加上 n-2
  
  
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

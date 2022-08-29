第一用recursive写 第二用DP写

class Solution {
    public int fib(int n) {
        return fibHelper(n);
    }
    public int fibHelper(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibHelper(n - 1) + fibHelper(n - 2);
    }
}


class Solution {
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0; 
        dp[1] = 1; 
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

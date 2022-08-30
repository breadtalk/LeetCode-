第一个办法找规律写出来的
class Solution {
    public int integerBreak(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int result = 1;
        int count = n / 3;
        int residue = n % 3;
        if(residue == 0){
            for(int i = count; i > 0; i--){
                result = result * 3;
            }
        }
        else if(residue == 2){
            for( int i = count; i > 0; i--){
                result = result * 3;
            }
            result =result * residue;
        }
        else{
            for(int i = count; i > 1; i--){
                result = result *3;
            }
            result = result * 4;
        }
        return result;
    }
}


dp做法
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1]; 
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            for(int j = 1; j <= i-j; j++){
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }
        return dp[n];
    }
}

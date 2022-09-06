class Solution {
    public int numSquares(int n) {
        double sqrt = Math.sqrt((double)n);
        int[] perfectSquare = new int[(int)sqrt + 1];
        for(int i = 1; i < perfectSquare.length; i++){
            perfectSquare[i] = i*i;
            //System.out.print(perfectSquare[i]);
        }
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i < perfectSquare.length; i++){
            for(int j = 0; j <= n; j++){
                if(j >= perfectSquare[i] && dp[j - perfectSquare[i]]!=0){
                    if(dp[j] == 0){
                        dp[j] = dp[j-perfectSquare[i]]+1;
                    }
                    else{
                        dp[j] = Math.min(dp[j], dp[j-perfectSquare[i]]+1);
                    }
                }
            }
        }
        return dp[n]-1;
    }
}

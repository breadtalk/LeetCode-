class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i = 0; i < stones.length; i++){
            sum = sum + stones[i];
        }
        int[][] dp = new int[stones.length][sum/2+1];
        for(int i = 0; i < stones.length; i++){
            dp[i][0] = 0;
        }

        for(int j = stones[0]; j < sum/2+1; j++){
            dp[0][j] = stones[0];
        }
        
        for(int j = 1; j < sum/2+1; j++){
            for(int i = 1; i < stones.length; i++){
                if(j < stones[i]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stones[i]]+stones[i]);
                }
            }
        }
        
        
        
        /*for(int i = 0; i < stones.length; i++){
            for(int j = 0; j < sum/2+1; j++){
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }*/
        
        
        return Math.abs(dp[stones.length-1][sum/2] - (sum-dp[stones.length-1][sum/2]));
    }
}

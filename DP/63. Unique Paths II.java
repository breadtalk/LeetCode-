similar to 62
  
  
  class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] dp = new int[row][column];
        if(obstacleGrid[0][0] == 1){
            dp[0][0] = 0;
        }
        else{
            dp[0][0] = 1;
        }
        
        
        for(int i = 1; i < row; i++){
            if(obstacleGrid[i][0] != 1){
                dp[i][0] = dp[i-1][0];
            }
            else{
                dp[i][0] = 0;
            }
        }
        
        for(int j = 1; j < column; j++){
            if(obstacleGrid[0][j] != 1){
                dp[0][j] = dp[0][j-1];
            }
            else{
                dp[0][j] = 0;
            }
        }
        
        for(int m = 1; m < row; m++){
            for(int n = 1; n < column; n++){
                if(obstacleGrid[m][n] == 1){
                    dp[m][n] = 0;
                }
                else{
                    dp[m][n] = dp[m-1][n] + dp[m][n-1];
                }
            }
        }
        return dp[row-1][column-1];
        
    }
}

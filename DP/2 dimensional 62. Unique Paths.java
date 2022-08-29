class Solution {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        for(int i = 0; i < m; i++){
            path[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            path[0][j] =1;
        }
        for(int a = 1; a < m; a++){
            for(int b = 1; b < n; b++){
                path[a][b] = path[a-1][b] + path[a][b-1];
            }
        }
        return path[m-1][n-1];
    }
}

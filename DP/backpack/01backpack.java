第一个方法是二维数组
用二维数组的时候先遍历背包还是先遍历物品都可以
并且是 正序 

第二个方法是一维数组
先遍历物理在遍历背包重量 反过来不行 反过来的话就一直再遍历同一个物品
倒序 保证每一个物品只添加一次 



import java.util.*;

public class test {
  public static void main(String[] args) {
    int[] weight = {1, 3, 4};
    int[] value = {15, 20, 30};
    int bagsize = 4;
    backPackProblem(weight, value, bagsize);
  }

  public static void backPackProblem(int[] weight, int[] value, int bagsize){
    int[][] dp = new int[weight.length][bagsize + 1];
    for(int i = 0; i < weight.length; i++){
      dp[i][0] = 0;
    }
    for(int j = 0; j < weight[0]; j++){
      dp[0][j] = 0;
    }
    for(int j = weight[0]; j <= bagsize; j++){
      dp[0][j] = value[0];
    }
    for(int j = 1; j < bagsize+1; j++){
      for(int i = 1; i < weight.length; i++){
        if(j < weight[i]){
          dp[i][j] = dp[i-1][j];
        }
        else{
          dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
        }
      }
    }



    for(int i = 0; i < dp.length; i++){
      for(int j = 0; j < dp[0].length; j++){
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
  }
}






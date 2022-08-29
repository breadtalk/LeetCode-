class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] sum = new int[2];
        sum[0] = 0;
        sum[1] = 0;
        
        for(int index = 2; index < cost.length + 1; index ++){
            int temp = Math.min((sum[1]+cost[index-1]), (sum[0] + cost[index-2]));
            sum[0] = sum[1];
            sum[1] = temp;
        }
        return sum[1];
    }
}

先让一个candies array 全部都是1 满足第一个条件 每人都有一个糖
先从左到右走一遍 只比较右边是否大于左边 大于的加1 不大于的维持1
再从右边往左边走一遍 只比较左边的是不是大于右边 大于的加1
然后计算sum


class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        if(ratings.length == 1){
            return 1;
        }
        candies[0]=1;
        for(int i = 0; i < ratings.length-1; i++){
            if(ratings[i+1] > ratings[i]){
                candies[i+1] = candies[i] + 1;
            }
            else{
                candies[i+1] = 1;
            }
        }
        
        for(int j = ratings.length-1; j > 0; j--){
            if(ratings[j-1] > ratings[j]){
                candies[j-1] = Math.max(candies[j] + 1, candies[j-1]);
            }
        }
        int sum = 0;
        for(int k = 0; k < candies.length; k++){
            sum = sum + candies[k];
        }
        return sum;
    }
}

如果加起来的数字是小于0 肯定对后面没有贡献 所以从0开始重新计数

class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer. MIN_VALUE; 
        int count =  0;
        for(int i = 0; i< nums.length; i++){
            count = count + nums[i];
            if(result < count){
                result = count;
            }
            if(count < 0){
                count = 0; 
            }
        }
        return result;
    }
}

要特别注意有0的情况
第一个是零的情况
以及零以后仍然是单调递增递减的情况

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int currDiff;
        int count = 1;
        int preDiff = 0;
        int i = 1;
        while(i < nums.length){
            currDiff = nums[i] - nums[i-1];
            if(currDiff * preDiff < 0){
                count ++;
                i++;
                preDiff = currDiff;
            }
            else if(currDiff * preDiff == 0 && currDiff != 0){
                count ++;
                i++;
                preDiff = currDiff;
            }
            else if(currDiff * preDiff == 0){
                i++;
            }
            else{
                i++;
                preDiff = currDiff;
            }
        }
        return count;
    }
}

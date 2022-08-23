只需要求maxLength能否cover到你需要去的i

class Solution {
    public boolean canJump(int[] nums) {
        int maxLength = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(maxLength < i){
                return false;
            }
            maxLength = Math.max(maxLength, nums[i]+i);
        }
        return true;
    }
}

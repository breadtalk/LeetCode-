class Solution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int[] returnValue = new int[2];
        while(i<j){
            if((nums[i]+nums[j])>target){
                j=j-1;
            }
            else if((nums[i]+nums[j])<target){
                i=i+1;
            }
            else{
                returnValue=new int[]{i,j};
            }
        }
        return returnValue;
    }
}

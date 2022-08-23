过了但是solution并不好

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        while(k > 0){
            nums[0] = -nums[0];
            k--;
            Arrays.sort(nums);
        }
        int sum = 0;
        for(int j:nums){
            sum = sum + j;
        }
        return sum;
    }
}

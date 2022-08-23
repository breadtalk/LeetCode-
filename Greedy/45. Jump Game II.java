考虑下一步所能覆盖的最大长度
然后选下一步能覆盖的最大长度那个节点跟length比
如果不行的话 再选下一步能覆盖的最大长度

几个edge case 如果长度=1 return0 
如果第一步就能走到return 1
然后再考虑剩下的情况

class Solution {
    
    public int jump(int[] nums) {
        int jumpNumber = 1;
        int startPoint = 1;
        int endPoint = nums[0];
        int maxLength = nums[0];
        if(nums.length == 1){
            return 0;
        }
        if(maxLength > nums.length-1){
            return jumpNumber;
        }
        while(maxLength < nums.length-1){
            jumpNumber++;
            for(int i = startPoint; i <= endPoint; i++){
                int temp = nums[i] + i;
                if(temp > maxLength){
                    maxLength = nums[i] + i;
                    startPoint = i;
                }
            }
            endPoint = maxLength;
        }
        return jumpNumber;
    }
}

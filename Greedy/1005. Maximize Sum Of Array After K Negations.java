好几种edge case

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;

        while(i < nums.length && k > 0 && nums[i] < 0){   //满足三个条件k大于0， i is within bound并且nums[i]<0  k全部走完 array里的负数还没用完
            nums[i] = -nums[i];
            k--;
            i++;
        }
        
                                                            //从这个while loop出来很多种情况                
        
        int absMinI; 
        if(i == 0){                                         //array里面所有的数都是正数 
            absMinI = i;
        }
        else if(i == nums.length){                          //array里面所有的数都是负数 出来的时候i=nums.length以及out of bound了
            absMinI = i-1;
        }
        else{                                               //array里面有正有负 出来的时候负数已经用完k还没走完
            if(Math.abs(nums[i-1]) > Math.abs(nums[i])){
                absMinI = i;
            }
            else{
                absMinI = i-1;
            }
        }
        while(k > 0){                                       //反复iterate array里面绝对值最小的那个数字
            nums[absMinI] = -nums[absMinI];
            k--;
        }

        
        int sum = 0;                                         //计算sum
        for(int j:nums){
            sum = sum + j;
        }
        return sum;
    }
}

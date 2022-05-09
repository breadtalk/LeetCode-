注意 continue的用法
用双指针
改进的地方每次移动i 如果i已经>0 就不用继续下去了


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> returnList = new ArrayList<>();
        if(nums==null || nums.length<3){
            return (List)returnList;
        }
        Arrays.sort(nums);
        
        ArrayList<Integer> temp= new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if(nums[i]>0){
                return (List)returnList;
            }
            if(temp.size()>0 && temp.get(0)==nums[i]){
                continue;
            }
            else{
                int left = i+1;
                int right = nums.length-1;
                while(left<right){

                    if(nums[i]+nums[left]+nums[right]>0){
                        right--;
                    }
                    else if(nums[i]+nums[left]+nums[right]<0){
                        left++;
                    }
                    else{
                        temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        returnList.add((List)temp);
                        while(left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        left++;
                        right--;
                    }
                }
                
            }
           

        }
        return (List)returnList;
    }
}

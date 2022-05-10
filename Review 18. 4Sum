class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> returnList = new ArrayList<>();
        if(nums== null || nums.length<4){
            return (List)returnList;
        }
        
        Arrays.sort(nums);
        ArrayList<Integer> tempList = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(i > 0 && nums[i - 1] == nums[i]){
                continue;
            }
            else{
                for(int j=i+1;j<nums.length; j++){
                    
                    if(j > i + 1 && nums[j - 1] == nums[j]){
                        continue;
                    }
                    else{
                        int left = j+1;
                        int right = nums.length-1;

                        while(left<right){
                            int temp = nums[i]+nums[j]+nums[left]+nums[right];
                            if(temp<target){
                                left++;
                            }
                            else if(temp>target){
                                right--;
                            }
                            else{
                                tempList = new ArrayList<Integer>();
                                tempList.add(nums[i]);
                                tempList.add(nums[j]);
                                tempList.add(nums[left]);
                                tempList.add(nums[right]);
                                returnList.add((List)tempList);
                                while(left<right && nums[left+1]==nums[left]){
                                    left++;
                                }
                                while(left<right && nums[right]==nums[right-1]){
                                    right--;
                                }
                                left++;
                                right--;
                            }
                        }                    
                    }  
                }
            }
        }
        return (List)returnList;
    }
}

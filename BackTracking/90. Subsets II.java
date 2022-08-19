class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> subList = new LinkedList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result.add(new LinkedList());
        Arrays.sort(nums);
        subsetsHelper(nums, 0);
        return result;
        
    }
    public void subsetsHelper(int[] nums, int startPoint){
        if(startPoint >= nums.length){
            return;
        }
        for(int i = startPoint; i < nums.length; i++){
            if(i > startPoint && nums[i] == nums[i-1]){
                continue;
            }
            subList.add(nums[i]);
            result.add(new LinkedList(subList));
            subsetsHelper(nums, i+1);
            subList.removeLast();
        }   
    }
}

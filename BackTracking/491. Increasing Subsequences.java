


class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> subList = new LinkedList<>();
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        findHelper(nums, 0);
        return result;
        
    }
    
    public void findHelper(int[] nums, int startPoint){
        if(subList.size() >= 2){
            result.add(new LinkedList(subList));
        }
        if(startPoint >= nums.length){
            return;
        }
        
        ArrayList<Integer> used = new ArrayList<>();
        for(int i = startPoint; i < nums.length; i++){
            if(used.contains(nums[i])){
                continue;
            }
            if(!subList.isEmpty() && nums[i] < subList.getLast()){
                continue;
            }
            subList.add(nums[i]);
            used.add(nums[i]);
            findHelper(nums, i+1);
            subList.removeLast();        
        }
    }
}

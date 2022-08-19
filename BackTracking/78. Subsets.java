这道题是在每个节点收子集 没有中止条件

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> subList = new LinkedList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new LinkedList());
        subsetsHelper(nums, 0);
        return result;
    }
    public void subsetsHelper(int[] nums, int startIndex){
        
        for(int i = startIndex; i < nums.length; i++){
            subList.add(nums[i]);
            result.add(new LinkedList(subList));
            subsetsHelper(nums, i+1);
            subList.removeLast();
        }
    }
}

注意continue的用法
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> subList = new LinkedList<>();

    
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        permuteHelper(nums, used, 0);
        return result;
    }
    
    public void permuteHelper(int[] nums, boolean[] used, int startPoint){
        if(subList.size() == nums.length){
            result.add(new LinkedList(subList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            else{
                subList.add(nums[i]);
                used[i]=true;
                permuteHelper(nums, used, 0);
                subList.removeLast();
                used[i]=false;
            }
            
        }
        
    }
    
    
}

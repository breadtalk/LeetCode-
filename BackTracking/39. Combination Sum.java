class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> subList = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationHelper(candidates, target, 0);
        return result;
    }
    public void combinationHelper(int[] candidates, int target, int startPoint){
        if(sum == target){
            result.add(new LinkedList(subList));
            return; 
        }
        if(sum > target){
            return;
        }
        
        for(int i = startPoint; i < candidates.length; i++){
            subList.add(candidates[i]);
            sum = sum + candidates[i];
            combinationHelper(candidates, target, i);
            sum = sum - subList.removeLast();
            
        }
        
    }
}

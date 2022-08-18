这个去除重复的语句没看懂 要画出来才能看明白


class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> subList = new LinkedList<>();
    int sum = 0; 
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationHelper(candidates, target, 0);
        return result;
    }
    public void combinationHelper(int[] candidates, int target, int startPoint){
        if(target == sum){
            result.add(new LinkedList(subList));
            return;
        }
        if(sum > target){
            return;
        }
        for(int i = startPoint; i < candidates.length; i++){
            if( i > startPoint  && candidates[i] == candidates[i-1]){    //当你不在第一层的时候不能重复使用元素
                continue;
            }
            subList.add(candidates[i]);
            sum = sum + candidates[i];
            combinationHelper(candidates, target, i+1);
            sum = sum - subList.removeLast();
        }
    }
}

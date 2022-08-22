去重复这一步要再好好看看
1.去重要排序
2.当nums[i-1] ==  num[i] 的时候， 如果 used[i-1]是true说明上一层以及用过这个元素了， 可以重复取 如果used[i-1]是false的话 说明这个元素在这一层是重复的 不能重复取

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> subList = new LinkedList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean used[] = new boolean[nums.length];
        Arrays.sort(nums);
        permuteHelper(nums, used);
        return result;
        
    }
    public void permuteHelper(int[] nums, boolean[] used){
        if(subList.size() == nums.length){
            result.add(new LinkedList(subList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && used[i - 1] == false){
                continue;
            }
            subList.add(nums[i]);
            used[i]=true;
            permuteHelper(nums, used);
            subList.removeLast();
            used[i] = false;
        }
    }
} 

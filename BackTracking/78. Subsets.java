其实可以不需要加终止条件，因为startIndex >= nums.size()，本层for循环本来也结束了，本来我们就要遍历整棵树。

有的同学可能担心不写终止条件会不会无限递归？

并不会，因为每次递归的下一层就是从i+1开始的。

如果要写终止条件，注意：result.push_back(path);要放在终止条件的上面，如下：


class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> subList = new LinkedList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new LinkedList());
        subsetsHelper(nums, 0);
        return result;
    }
    public void subsetsHelper(int[] nums, int startIndex){
        if(startIndex >= nums.length){
            return;
        }
        
        for(int i = startIndex; i < nums.length; i++){
            subList.add(nums[i]);
            result.add(new LinkedList(subList));
            subsetsHelper(nums, i+1);
            subList.removeLast();
        }
    }
}

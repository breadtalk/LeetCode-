  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int start = 0; 
        int end = nums.length-1;
        return constructHelper(nums, start, end);
        
    }
    public TreeNode constructHelper(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        if(start == end){
            return new TreeNode(nums[start]);
        }
        int newCut = 0;
        int maxValue = Integer.MIN_VALUE;
        for(int i = start; i <= end; i++){
            if(nums[i] > maxValue){
                newCut = i;
                maxValue = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = constructHelper(nums, start, newCut-1);
        root.right = constructHelper(nums, newCut+1, end);
        return root;
    }
}

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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = sortedHelper(nums, 0, nums.length-1);
        return root;
    }
    public TreeNode sortedHelper(int[] nums, int start, int end){
        if(end - start < 0){
            return null;
        }
        if(start == end){
            return new TreeNode(nums[start]);
        }
        int cutPoint = (end + start + 1)/2;
        TreeNode root = new TreeNode(nums[cutPoint]);
        root.left = sortedHelper(nums, start, cutPoint-1);
        root.right = sortedHelper(nums, cutPoint+1, end);
        return root;
    }
}

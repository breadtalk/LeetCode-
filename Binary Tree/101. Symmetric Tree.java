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
    boolean isSymmetric = true;
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        isSymmetric(left, right);
        return isSymmetric;
    }
    public void isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return;
        }
        if(left == null || right == null){
            isSymmetric = false;
            return;
        }
        if(left.val != right.val){
            isSymmetric = false;
            return;
        }
        isSymmetric(left.right, right.left);
        isSymmetric(left.left, right.right);
    }
}

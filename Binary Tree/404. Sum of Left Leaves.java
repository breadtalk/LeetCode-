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
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return sum;
        }
        sum(root.left, true);
        sum(root.right, false);
        return sum;
        
    }
    public void sum(TreeNode node, boolean isLeft){
        if(node == null){
            return;
        }
        if(isLeft){
            if(node.left==null && node.right == null){
                sum = sum + node.val;
                return;
            }
            else{
                sum(node.left, true);
                sum(node.right, false);
            }
        }
        else{
            sum(node.left, true);
            sum(node.right, false);
        }
        
    }
}

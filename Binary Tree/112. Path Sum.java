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
    boolean hasPathSum = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        int sum =0;
        pathSumCal(root, targetSum, sum);
        return hasPathSum;
        
    }
    
    public void pathSumCal(TreeNode node, int targetSum, int sum){
        if(node == null){
            return;
        }
        sum = sum + node.val;
        if(node.left == null && node.right == null){
            if(sum == targetSum){
                hasPathSum = true;
                return;
            }
            sum = sum - node.val;
            return;
        }
        pathSumCal(node.left, targetSum, sum);
        pathSumCal(node.right, targetSum, sum); 
    }
}

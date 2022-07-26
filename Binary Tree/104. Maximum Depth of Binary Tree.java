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
    int maxDepth;
    
    public int maxDepth(TreeNode root){
        int depth = 0;
        maxDepth = 0;
        maxDepthDFS(depth,root);
        return maxDepth;
        
    }
    public void maxDepthDFS(Integer depth, TreeNode current){
        if (current == null){
            return;
        }
        depth++;
        maxDepth = Math.max(depth, maxDepth);
        maxDepthDFS(depth, current.left);
        maxDepthDFS(depth, current.right);
    }
    
    
}

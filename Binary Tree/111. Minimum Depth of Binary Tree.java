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
    int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        int depth = 0;
        if(root == null){
            return 0;
        }
        minDepthDFS(root, depth);
        return minDepth;
    }
    public void minDepthDFS(TreeNode node, int depth){
        if(node == null){
            return;
        }
        depth++;
        if(node.left == null && node.right == null){
            minDepth = Math.min(minDepth, depth);
        }
        minDepthDFS(node.left, depth);
        minDepthDFS(node.right, depth);
    }
    
    
}

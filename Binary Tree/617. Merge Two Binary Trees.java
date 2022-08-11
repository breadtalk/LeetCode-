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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergeHelper(root1, root2);
    }
    public TreeNode mergeHelper(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return null;
        }
        TreeNode root = new TreeNode();
        if(root2 == null){
            root = root1;
            root.left = mergeHelper(root1.left, null);
            root.right = mergeHelper(root1.right, null);
        }
        else if(root1 == null){
            root = root2;
            root.left = mergeHelper(null, root2.left);
            root.right = mergeHelper(null, root2.right);
        }
        else{
            root = new TreeNode(root1.val + root2.val);
            root.left = mergeHelper(root1.left, root2.left);
            root.right = mergeHelper(root1.right, root2.right);
        }
        return root;
        
    }
}

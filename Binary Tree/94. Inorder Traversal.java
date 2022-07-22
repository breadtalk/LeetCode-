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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> returnList = new LinkedList<>();
        inorderTraversalR(root, returnList);
        return returnList;
    }
    
    public void inorderTraversalR(TreeNode node, List<Integer> returnList){
        if(node == null){
            return;
        }
        this.inorderTraversalR(node.left, returnList);
        returnList.add(node.val);
        this.inorderTraversalR(node.right, returnList);
    }
}

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> returnList = new LinkedList<>();
        preorderTraversalR(root, returnList);
        return returnList;
    }
    
    public void preorderTraversalR(TreeNode current, List<Integer> returnList){
        if(current == null){
            return;
        }
        returnList.add(current.val);
        preorderTraversalR(current.left, returnList);
        preorderTraversalR(current.right, returnList);
    }
}

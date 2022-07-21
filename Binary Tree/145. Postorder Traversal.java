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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> returnList = new LinkedList<>();
        postorderTraversalR(root, returnList);
        return returnList;
    }
    public void postorderTraversalR(TreeNode current, List<Integer> returnList){
        if(current == null){
            return;
        }
        this.postorderTraversalR(current.left, returnList);
        this.postorderTraversalR(current.right, returnList);
        returnList.add(current.val);
    }
    
}

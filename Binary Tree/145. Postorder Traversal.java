第一个办法用recursive做
第二个办法用stack来做
Postorder 的顺序是 left right middle
反过来就是 middle right left 
放进stack 需要做 middle left right
然后最后反转整个串

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

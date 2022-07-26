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
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> returnList = new LinkedList<>();
        if(root == null){
            return returnList;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        rightSideViewBST(returnList, queue);
        return returnList;
        
    }
    public void rightSideViewBST(LinkedList<Integer> returnList, ArrayDeque<TreeNode> queue){
        if(queue.size() == 0){
            return;
        }
        int size = queue.size();
        TreeNode current = null;
        for (int i = 0; i < size; i++){
            current = queue.poll();
            if (current.left != null){
                queue.add(current.left);
            }
            if(current.right!=null){
                queue.add(current.right);
            }
        }
        returnList.add(current.val);
        rightSideViewBST(returnList,queue);
    }
}

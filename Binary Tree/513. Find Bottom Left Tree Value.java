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
    int value = 0;
    public int findBottomLeftValue(TreeNode root) {
        if(root == null){
            return 0;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        leftValue(queue);
        return value;
        
    }
    
    public void leftValue(ArrayDeque<TreeNode> queue){
        if(queue.isEmpty()){
            return;
        }
        int len= queue.size();
        for(int i = 0; i < len; i++){
            if(i == 0){
                TreeNode current = queue.poll();
                value = current.val;
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            else{
                TreeNode current = queue.poll();
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
        }
            
        leftValue(queue);
    }
}

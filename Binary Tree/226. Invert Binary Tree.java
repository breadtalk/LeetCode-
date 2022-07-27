第一种办法用level order traversal BFS
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        invertTreeBFS(queue);
        return root;
    }
    
    public void invertTreeBFS(ArrayDeque<TreeNode> queue){
        if(queue.isEmpty()){
            return;
        }
        int size = queue.size();
        for (int i = 0; i < size; i++){
            TreeNode current = queue.poll();
            switchNode(current);
            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right!=null){
                queue.add(current.right);
            }
        }
        invertTreeBFS(queue);
    }
    
    public void switchNode(TreeNode current){
        TreeNode temp = current.left;
        current.left=current.right;
        current.right=temp;
        return;
    }
}

第一个办法是O（nlogn)
  
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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs((getHeight(root.left)-getHeight(root.right)))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right))+1;
    }
}


第二个办法再计算height的时候同时计算是不是balanced 一旦不是balanced就推出O(n)
  
  
  
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
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return balanced;
        }
        getHeight(root);
        return balanced;

        
    }
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1){
            balanced = false;
        }
        return Math.max(left,right)+1;
    }
}
  

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
    public TreeNode deleteNode(TreeNode root, int key) {
        root = delete(root, key);
        return root;
    }
    public TreeNode delete(TreeNode node, int key){
        if(node == null){
            return null;
        }
        if(key > node.val){
            node.right = delete(node.right, key);
        }
        else if(key < node.val){
            node.left = delete(node.left, key);
        }
        else{
            if(node.left == null){
                return node.right;
            }
            if(node.right == null){
                return node.left;
            }
            TreeNode temp = node.right;
            while(temp.left != null){
                temp = temp.left;
            }
            node.val = temp.val;
            node.right = delete(node.right, temp.val);           
        }
        return node;
    }
    

}

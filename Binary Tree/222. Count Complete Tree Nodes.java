计算左边树和右边树的高度
如果左边树和右边树一样高那左边是完整树 return 1 + 左边完整树节点加上右边count
如果右边树矮 拿右边是完整树 return 1 + 右边完整树节点 + 左边count


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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = countDepth(root.left);
        int right = countDepth(root.right);
        if(left == right){
            return 1 + ((int)Math.pow(2,left)-1) + countNodes(root.right);
        }
        else{
            return 1 + ((int)Math.pow(2, right)-1) + countNodes(root.left);
        }
        
    }
    
    public int countDepth(TreeNode node){
        int depth = 0;
        while (node != null){
            depth ++;
            node = node.left;
        }
        return depth;
    }
}

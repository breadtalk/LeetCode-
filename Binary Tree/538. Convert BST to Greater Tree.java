这个树并没有改变结构 所以不需要node.left node.right 返回值
需要一个global variable来算sum所以要把sum放在global variable
计算顺序是右中左

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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        calculateSum(root);
        return root;
    }
    public void calculateSum(TreeNode node){
        if(node== null){
            return;
        }
        calculateSum(node.right);
        sum = node.val + sum;
        node.val = sum;
        calculateSum(node.left);
    }
}

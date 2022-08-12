delete一个node有很多种情况
有以下五种情况：
第一种情况：没找到删除的节点，遍历到空节点直接返回了
找到删除的节点
第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
第五种情况：左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，返回删除节点右孩子为新的根节点。

delete helper method return的是一个node
这样的话可以用look ahead method 保证node和他的左孩子右孩子之间的联系


第五种情况 先保存新节点然后旧节点的右孩子变成 delete新节点之后return的root

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

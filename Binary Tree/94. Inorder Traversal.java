第一种方法用recursive
第二种方法用stack
把所有的左边的node放进去直到null
然后开始pop每pop出来一个先存value然后检查右儿子




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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> returnList = new LinkedList<>();
        inorderTraversalR(root, returnList);
        return returnList;
    }
    
    public void inorderTraversalR(TreeNode node, List<Integer> returnList){
        if(node == null){
            return;
        }
        this.inorderTraversalR(node.left, returnList);
        returnList.add(node.val);
        this.inorderTraversalR(node.right, returnList);
    }
}


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
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> returnList = new LinkedList<>();
        if(root == null){
            return returnList;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            else{
                curr = stack.pop();
                returnList.add(curr.val);
                curr = curr.right;
            }
        }
        return returnList;
    }
}

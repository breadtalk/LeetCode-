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
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> returnList = new ArrayList<>();
        if(root == null){
            return returnList;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        largestValuesBFS(returnList, queue);
        return returnList;
    }
    
    public void largestValuesBFS(ArrayList<Integer> returnList, ArrayDeque<TreeNode> queue){
        if(queue.isEmpty()){
            return;
        }
        int max = Integer.MIN_VALUE;
        int size = queue.size();
        for (int i = 0; i < size; i++){
            TreeNode current = queue.poll();
            max = Math.max(current.val, max);
            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }
        }
        returnList.add(max);
        largestValuesBFS(returnList, queue);
    }
}

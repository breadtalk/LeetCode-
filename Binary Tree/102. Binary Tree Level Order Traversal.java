第一个用BFS的方法 注意arrayDeque的用法
第二种方法用DFS来做level order traversal
用一个int来track which level you are at recursive每次回去的时候回到原来的level


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> returnList = new LinkedList<List<Integer>>();
        if(root == null){
            return returnList;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        levelOrderBFS(queue, returnList);
        return returnList;
    }
    
    public void levelOrderBFS(ArrayDeque<TreeNode> queue, List<List<Integer>> returnList){
        if(queue.size() == 0){
            return;
        }
        List<Integer> sublist = new LinkedList<>();
        int len = queue.size();
        TreeNode curr;
        for(int i=0; i<len; i++){
            curr = queue.poll();
            sublist.add(curr.val);
            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
        }
        returnList.add(sublist);
        levelOrderBFS(queue,returnList);
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();
        levelOrderDFS(returnList, root, 0);
        return returnList;
        
    }
    public void levelOrderDFS(List<List<Integer>> returnList, TreeNode node, Integer depth){
        if (node == null){
            return;
        }
        depth++;
        
        if(returnList.size()<depth){
            ArrayList<Integer> newLevel = new ArrayList<>();
            returnList.add(newLevel);
        }
        returnList.get(depth-1).add(node.val);
        levelOrderDFS(returnList, node.left, depth);
        levelOrderDFS(returnList, node.right, depth);
        
        
    }
    

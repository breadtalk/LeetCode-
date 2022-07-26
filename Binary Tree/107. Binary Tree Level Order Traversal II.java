和102题很类似用DFS来做level order traversal

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            returnList.add(0, newLevel);
        }
        returnList.get(returnList.size()-depth).add(node.val);
        levelOrderDFS(returnList, node.left, depth);
        levelOrderDFS(returnList, node.right, depth);
    }
}


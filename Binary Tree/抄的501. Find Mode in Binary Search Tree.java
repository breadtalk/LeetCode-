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
    Integer pre = null;
    int count = 1; 
    int max = 0;
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> modes = new ArrayList<>();
        
        findHelper(root, modes);
        
        int[] results = new int[modes.size()];
        for (int i=0; i < modes.size();i++){
            results[i] = modes.get(i);
        }
        return results;
    }
    
    public void findHelper(TreeNode node, ArrayList<Integer> modes){
        if(node == null){
            return;
        }
        findHelper(node.left, modes);
        if(pre != null){
            if(pre == node.val){
                count++;
            }
            else{
                count = 1;
            }
        }
        if(count == max){
            modes.add(node.val);
        }
        else if(count > max){
            modes.clear();
            modes.add(node.val);
            max = count;
        }
        pre = node.val;
        
        findHelper(node.right, modes);
    }
}

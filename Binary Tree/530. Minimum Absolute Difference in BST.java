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
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> returnList = new ArrayList<>();
        inOrderHelper(root, returnList);
        int first = returnList.get(0);
        int second = returnList.get(1);
        int difference = second - first;
        for(int i = 2; i < returnList.size(); i++){
            if(difference == 1){
                break;
            }
            first = second;
            second = returnList.get(i);
            if((second - first) < difference){
                difference = second-first;
            }
        }
        return difference;
    }
    public void inOrderHelper(TreeNode node, ArrayList<Integer> returnList){
        if(node == null){
            return;
        }
        inOrderHelper(node.left, returnList);
        returnList.add(node.val);
        inOrderHelper(node.right, returnList);
    }
}

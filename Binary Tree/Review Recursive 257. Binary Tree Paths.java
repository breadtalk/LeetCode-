注意中止条件
以及recursive回来的时候要把本来那个node减掉
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
    List<String> returnList = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return returnList;
        }
        ArrayList<Integer> sublist = new ArrayList<>();
        sublistBuilder(root, sublist);
        return returnList;
        
    }
    
    public void sublistBuilder(TreeNode root, ArrayList<Integer> sublist){
        if(root.left == null && root.right == null){
            sublist.add(root.val);
            StringBuilder str = new StringBuilder();
            for(int i=0;i < sublist.size()-1;i++){
                str.append(sublist.get(i));
                str.append("->");
            }
            str.append(sublist.get(sublist.size()-1));
            returnList.add(str.toString());
            sublist.remove(sublist.size()-1);
            return;
        }
        if(root.left != null){
            sublist.add(root.val);
            sublistBuilder(root.left, sublist);
            sublist.remove(sublist.size()-1);
        }
        if(root.right != null){
            sublist.add(root.val);
            sublistBuilder(root.right, sublist);
            sublist.remove(sublist.size()-1);
        }
        
    }
}

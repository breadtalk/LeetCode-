2是已经被摄像头覆盖的
1是放置的摄像头
0是需要被覆盖



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
    int count = 0;
    public int minCameraCover(TreeNode root) {
        if(minCameraHelper(root) == 0){
            count++;
        }
        return count;
    }
    public int minCameraHelper(TreeNode node){
        if(node == null){
            return 2;
        }
        int left = minCameraHelper(node.left);
        int right = minCameraHelper(node.right);
        
        if(left == 2 && right == 2){
            return 0;
        }
        if(left == 0|| right == 0){
            count++;
            return 1;
        }
        return 2;
        
    }
    
}

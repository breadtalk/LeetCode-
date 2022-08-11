节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。


要知道中序遍历下，输出的二叉搜索树节点的数值是有序序列。
有了这个特性，验证二叉搜索树，就相当于变成了判断一个序列是不是递增的了。
以上代码中，我们把二叉树转变为数组来判断，是最直观的，但其实不用转变成数组，可以在递归遍历的过程中直接判断是否有序。

这道题目比较容易陷入两个陷阱：

陷阱1
不能单纯的比较左节点小于中间节点，右节点大于中间节点就完事了。
**我们要比较的是 左子树所有节点小于中间节点，右子树所有节点大于中间节点。**所以以上代码的判断逻辑是错误的。
陷阱2
样例中最小节点 可能是int的最小值，如果这样使用最小的int来比较也是不行的。
此时可以初始化比较元素为longlong的最小值。
问题可以进一步演进：如果样例中根节点的val 可能是longlong的最小值 又要怎么办呢？文中会解答。
了解这些陷阱之后我们来看一下代码应该怎么写：


第一种做法 recursive 用一个bound min max来看node val是不是再这个范围里
然后recursively 用node.val来update min max value
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
    public boolean isValidBST(TreeNode root) {
        return isValidHelper(root, Long.MAX_VALUE, Long.MIN_VALUE);
        
    }
    public boolean isValidHelper(TreeNode node, long max, long min){
        if(node == null){
            return true; 
        }
        if(node.val >= max || node.val <= min){
            return false;
        }
        return isValidHelper(node.left, node.val, min) && isValidHelper(node.right, max, node.val);
    }
}


第二个办法用inorder traversal 然后看是不是单调递增
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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        ArrayList<Integer> returnList = new ArrayList<>();
        inOrderHelper(root, returnList);
        long min = Long.MIN_VALUE;
        for(int i = 0; i < returnList.size(); i++){
            if(returnList.get(i) <= min){
                return false;
            }
            min = returnList.get(i);
        }
        return true;
        
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


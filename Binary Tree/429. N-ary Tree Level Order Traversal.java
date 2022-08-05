/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<List<Integer>> returnList = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root== null){
            return returnList;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        levelOrderBFS(queue);
        return returnList;
        
    }
    public void levelOrderBFS(ArrayDeque<Node> queue){
        if(queue.isEmpty()){
            return;
        }
        List<Integer> subList = new ArrayList<>();
        int len = queue.size();
        for (int i = 0; i < len; i++){
            Node current = queue.poll();
            subList.add(current.val);
            for(Node child: current.children){
                queue.add(child);
            }
        }
        returnList.add(subList);
        levelOrderBFS(queue);
    }
}

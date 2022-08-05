/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        levelOrderBFS(queue);
        return root;
        
    }
    public void levelOrderBFS(ArrayDeque<Node> queue){
        if(queue.isEmpty()){
            return;
        }
        if(queue.size() == 1){
            Node current = queue.poll();
            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }
        }
        else{
            int len = queue.size();
            Node current = queue.poll();
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            for(int i = 1; i < len; i++){
                Node next = queue.poll();
                if(next.left != null){
                    queue.add(next.left);
                }
                if(next.right != null){
                    queue.add(next.right);
                }
                current.next = next;
                current = next;
            }
        }

        levelOrderBFS(queue);
    }
}

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
//USING BFS
// class Solution {
//     public Node connect(Node root) {
//         if (root == null)
//             return null;
//         Queue<Node> queue = new LinkedList<>();
//         queue.offer(root);
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             Node prev = null;
//             for (int i = 0; i < size; i++) {
//                 Node curr = queue.poll();
//                 if (prev != null)
//                     prev.next = curr;
//                 prev = curr;
//                 if (curr.left != null)
//                     queue.offer(curr.left);
//                 if (curr.right != null)
//                     queue.offer(curr.right);
//             }
//             prev.next = null;
//         }
//         return root;
//     }
// }

//USING DFS
class Solution {
    public Node connect(Node root) {
        Node curr = root;
        while (curr != null) {
            Node head = null;
            Node prev = null;
            while (curr != null) {
                if (curr.left != null) {
                    if (head == null)
                        head = curr.left;
                    if (prev != null)
                        prev.next = curr.left;
                    prev = curr.left;
                }
                if (curr.right != null) {
                    if (head == null)
                        head = curr.right;
                    if (prev != null)
                        prev.next = curr.right;
                    prev = curr.right;
                }
                curr = curr.next;
            }
            curr = head;
        }
        return root;
    }
}
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
//USING BFS
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();

            if (n1 == null && n2 == null)
                continue;

            if (n1 == null || n2 == null)
                return false;

            if (n1.val != n2.val)
                return false;

            q1.offer(n1.left);
            q1.offer(n1.right);

            q2.offer(n2.left);
            q2.offer(n2.right);
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}


//USING DFS
// class Solution {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         if(p == null && q == null) {
//             return true;
//         }
//         if(p == null || q == null) {
//             return false;
//         }
//         if(p.val != q.val) {
//             return false;
//         }
//         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//     }
// }
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
// USING RECURSIVE
class Solution {
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }
    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null)
            minDiff = Math.min(minDiff, root.val - prev);
        prev = root.val;
        inorder(root.right);
    }
}
// USING ITERATOR
// class Solution {
//     public int getMinimumDifference(TreeNode root) {
//         Stack<TreeNode> stack = new Stack<>();
//         Integer prev = null;
//         int minDiff = Integer.MAX_VALUE;
//         while (root != null || !stack.isEmpty()) {
//             while (root != null) {
//                 stack.push(root);
//                 root = root.left;
//             }
//             root = stack.pop();
//             if (prev != null)
//                 minDiff = Math.min(minDiff, root.val - prev);
//             prev = root.val;
//             root = root.right;
//         }
//         return minDiff;
//     }
// }
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
//USING RANGE METHOD
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean validate(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        return validate(root.left, min, root.val)
                && validate(root.right, root.val, max);
    }
}

//USING INORDER METHOD
// class Solution {
//     private TreeNode prev = null;
//     public boolean isValidBST(TreeNode root) {
//         return inorder(root);
//     }
//     private boolean inorder(TreeNode root) {
//         if (root == null)
//             return true;
//         if (!inorder(root.left))
//             return false;
//         if (prev != null && root.val <= prev.val)
//             return false;
//         prev = root;
//         return inorder(root.right);
//     }
// }
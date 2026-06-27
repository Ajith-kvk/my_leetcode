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
    private int postIndex;
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] inorder, int[] postorder,
                           int left, int right) {
        if (left > right)
            return null;
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        int mid = inorderMap.get(rootVal);
        // Build RIGHT first
        root.right = build(inorder, postorder, mid + 1, right);
        // Then LEFT
        root.left = build(inorder, postorder, left, mid - 1);
        return root;
    }
}
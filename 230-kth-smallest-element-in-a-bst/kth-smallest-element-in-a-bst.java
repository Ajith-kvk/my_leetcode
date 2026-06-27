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
 //USING RECURSIVE
class Solution {
    private int count = 0;
    private int answer = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return answer;
    }
    private void inorder(TreeNode node, int k) {
        if(node == null) {
            return;
        }
        inorder(node.left, k);
        count++;
        if(count == k) {
            answer = node.val;
            return;
        }
        inorder(node.right, k);
    }
}

//USING ITERATIVE
// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         Stack<TreeNode> stack = new Stack<>();
//         while (root != null || !stack.isEmpty()) {
//             while (root != null) {
//                 stack.push(root);
//                 root = root.left;
//             }
//             root = stack.pop();
//             k--;
//             if (k == 0)
//                 return root.val;
//             root = root.right;
//         }
//         return -1;
//     }
// }
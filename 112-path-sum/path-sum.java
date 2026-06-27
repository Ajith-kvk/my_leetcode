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
//  USING BFS
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sumPath = new Stack<>();
        path.push(root);
        sumPath.push(root.val);
        while(!path.isEmpty()) {
            TreeNode temp = path.pop();
            int tempVal = sumPath.pop();
            if(temp.left == null &&
               temp.right == null &&
               tempVal == targetSum) {
                return true;
            }
            if(temp.right != null) {
                path.push(temp.right);
                sumPath.push(tempVal + temp.right.val);
            }
            if(temp.left != null) {
                path.push(temp.left);
                sumPath.push(tempVal + temp.left.val);
            }
        }
        return false;
    }
}
//USING DFS
// class Solution {
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         if (root == null)
//             return false;
//         targetSum -= root.val;
//         if (root.left == null && root.right == null)
//             return targetSum == 0;
//         return hasPathSum(root.left, targetSum)
//                 || hasPathSum(root.right, targetSum);
//     }
// }
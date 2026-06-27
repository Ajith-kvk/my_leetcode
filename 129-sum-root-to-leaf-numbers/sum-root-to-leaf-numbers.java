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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode node, int currentNumber) {
        if(node == null) {
            return 0;
        }
        currentNumber = currentNumber * 10 + node.val;
        // leaf node
        if(node.left == null && node.right == null) {
            return currentNumber;
        }
        return dfs(node.left, currentNumber)
             + dfs(node.right, currentNumber);
    }
}

//USING DFS(STACK)
// class Solution {
//     public int sumNumbers(TreeNode root) {
//         if (root == null)
//             return 0;
//         int sum = 0;
//         Stack<Pair<TreeNode, Integer>> stack = new Stack<>();//Note: On LeetCode Java, Pair is not always available. You can instead create a small custom class or use two parallel stacks.
//         stack.push(new Pair<>(root, root.val));
//         while (!stack.isEmpty()) {
//             Pair<TreeNode, Integer> pair = stack.pop();
//             TreeNode node = pair.getKey();
//             int current = pair.getValue();
//             if (node.left == null && node.right == null) {
//                 sum += current;
//                 continue;
//             }
//             if (node.right != null)
//                 stack.push(new Pair<>(node.right,
//                         current * 10 + node.right.val));
//             if (node.left != null)
//                 stack.push(new Pair<>(node.left,
//                         current * 10 + node.left.val));
//         }
//         return sum;
//     }
// }
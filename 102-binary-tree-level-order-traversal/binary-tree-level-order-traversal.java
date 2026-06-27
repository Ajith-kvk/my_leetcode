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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i=0; i<levelSize; i++) {
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);
                if(currNode.left != null) {
                    queue.add(currNode.left);
                }
                if(currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            result.add(currLevel);
        }
        return result;
    }
}
// USING DFS
// class Solution {
//     public List<Double> averageOfLevels(TreeNode root) {
//         List<Long> sums = new ArrayList<>();
//         List<Integer> counts = new ArrayList<>();
//         dfs(root, 0, sums, counts);
//         List<Double> ans = new ArrayList<>();
//         for (int i = 0; i < sums.size(); i++) {
//             ans.add((double) sums.get(i) / counts.get(i));
//         }
//         return ans;
//     }
//     private void dfs(TreeNode root, int depth,
//                      List<Long> sums,
//                      List<Integer> counts) {
//         if (root == null)
//             return;
//         if (depth == sums.size()) {
//             sums.add((long) root.val);
//             counts.add(1);
//         } else {
//             sums.set(depth, sums.get(depth) + root.val);
//             counts.set(depth, counts.get(depth) + 1);
//         }
//         dfs(root.left, depth + 1, sums, counts);
//         dfs(root.right, depth + 1, sums, counts);
//     }
// }
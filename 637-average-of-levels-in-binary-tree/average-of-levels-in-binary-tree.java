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
// USING BFS
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            ans.add((double) sum / size);
        }
        return ans;
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
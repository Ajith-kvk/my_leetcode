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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        if(root == null) return zigzag;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            Stack<Integer> reverseStack = new Stack<>();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(flag) {
                    reverseStack.add(node.val);
                }else{
                    level.add(node.val);
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            flag = !flag;
            while(!reverseStack.isEmpty()) {
                level.add(reverseStack.pop());
            }
            zigzag.add(level);
        }
        return zigzag;
    }
}
// USING DFS
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> ans = new ArrayList<>();
//         dfs(root, 0, ans);
//         return ans;
//     }
//     private void dfs(TreeNode root, int depth,
//                      List<List<Integer>> ans) {
//         if (root == null)
//             return;
//         if (depth == ans.size())
//             ans.add(new ArrayList<>());
//         ans.get(depth).add(root.val);
//         dfs(root.left, depth + 1, ans);
//         dfs(root.right, depth + 1, ans);
//     }
// }
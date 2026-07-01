//TOP-DOWN APPROACH
class Solution {
    Integer[][] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new Integer[m][n];
        return solve(grid, 0, 0);
    }
    private int solve(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        if (r == m - 1 && c == n - 1)
            return grid[r][c];
        if (r >= m || c >= n)
            return Integer.MAX_VALUE;
        if (dp[r][c] != null)
            return dp[r][c];
        int down = solve(grid, r + 1, c);
        int right = solve(grid, r, c + 1);
        int best = Math.min(down, right);
        if (best == Integer.MAX_VALUE)
            dp[r][c] = Integer.MAX_VALUE;
        else
            dp[r][c] = grid[r][c] + best;
        return dp[r][c];
    }
}
//BOTTOM-UP APPROACH
// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int[][] dp = new int[m][n];
//         dp[0][0] = grid[0][0];
//         for (int i = 1; i < m; i++)
//             dp[i][0] = dp[i - 1][0] + grid[i][0];
//         for (int j = 1; j < n; j++)
//             dp[0][j] = dp[0][j - 1] + grid[0][j];
//         for (int i = 1; i < m; i++) {

//             for (int j = 1; j < n; j++) {
//                 dp[i][j] = grid[i][j]
//                         + Math.min(dp[i - 1][j], dp[i][j - 1]);
//             }
//         }
//         return dp[m - 1][n - 1];
//     }
// }
//SPACE-OPTIMIZED APPROACH
// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int[] dp = new int[n];
//         dp[0] = grid[0][0];
//         for (int j = 1; j < n; j++)
//             dp[j] = dp[j - 1] + grid[0][j];
//         for (int i = 1; i < m; i++) {
//             dp[0] += grid[i][0];
//             for (int j = 1; j < n; j++) {
//                 dp[j] = grid[i][j]
//                         + Math.min(dp[j], dp[j - 1]);
//             }
//         }
//         return dp[n - 1];
//     }
// }
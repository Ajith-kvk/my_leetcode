//TOP-DOWN APPROACH
class Solution {
    Integer[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new Integer[m][n];
        return solve(obstacleGrid, 0, 0);
    }
    private int solve(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        if (r >= m || c >= n)
            return 0;
        if (grid[r][c] == 1)
            return 0;
        if (r == m - 1 && c == n - 1)
            return 1;
        if (dp[r][c] != null)
            return dp[r][c];
        dp[r][c] = solve(grid, r + 1, c)
                 + solve(grid, r, c + 1);
        return dp[r][c];
    }
}
//BOTTOM-UP APPROACH
// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         int[][] dp = new int[m][n];
//         if (obstacleGrid[0][0] == 1)
//             return 0;
//         dp[0][0] = 1;
//         // First column
//         for (int i = 1; i < m; i++) {
//             if (obstacleGrid[i][0] == 0)
//                 dp[i][0] = dp[i - 1][0];
//         }
//         // First row
//         for (int j = 1; j < n; j++) {
//             if (obstacleGrid[0][j] == 0)
//                 dp[0][j] = dp[0][j - 1];
//         }
//         for (int i = 1; i < m; i++) {
//             for (int j = 1; j < n; j++) {
//                 if (obstacleGrid[i][j] == 1) {
//                     dp[i][j] = 0;
//                 } else {
//                     dp[i][j] = dp[i - 1][j]
//                              + dp[i][j - 1];
//                 }
//             }
//         }
//         return dp[m - 1][n - 1];
//     }
// }
//SPACE-OPTIMIZED APPROACH
// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         int[] dp = new int[n];
//         dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (obstacleGrid[i][j] == 1) {
//                     dp[j] = 0;
//                 } else if (j > 0) {
//                     dp[j] += dp[j - 1];
//                 }
//             }
//         }
//         return dp[n - 1];
//     }
// }
//BOTTOM-UP APPROACH
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        // Copy last row
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j)
                        + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
}
//TOP-DOWN APPROACH
// class Solution {
//     Integer[][] dp;
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         dp = new Integer[n][n];
//         return solve(triangle, 0, 0);
//     }
//     private int solve(List<List<Integer>> triangle, int r, int c) {
//         if (r == triangle.size() - 1)
//             return triangle.get(r).get(c);
//         if (dp[r][c] != null)
//             return dp[r][c];
//         int down = solve(triangle, r + 1, c);
//         int diagonal = solve(triangle, r + 1, c + 1);
//         dp[r][c] = triangle.get(r).get(c) + Math.min(down, diagonal);
//         return dp[r][c];
//     }
// }
//SPACE-OPTIMIZED APPROACH
// class Solution {

//     public int minimumTotal(List<List<Integer>> triangle) {

//         int n = triangle.size();

//         int[] dp = new int[n];

//         // Initialize with last row
//         for (int j = 0; j < n; j++) {
//             dp[j] = triangle.get(n - 1).get(j);
//         }

//         for (int i = n - 2; i >= 0; i--) {

//             for (int j = 0; j <= i; j++) {

//                 dp[j] = triangle.get(i).get(j)
//                         + Math.min(dp[j], dp[j + 1]);
//             }
//         }

//         return dp[0];
//     }
// }
//TOP-BOTTOM APPROACH
class Solution {
    Integer[][][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2][3];
        return solve(prices, 0, 1, 2);
    }
    private int solve(int[] prices, int i, int buy, int cap) {
        if (i == prices.length || cap == 0)
            return 0;
        if (dp[i][buy][cap] != null)
            return dp[i][buy][cap];
        if (buy == 1) {
            int buyStock =
                    -prices[i] + solve(prices, i + 1, 0, cap);
            int skip =
                    solve(prices, i + 1, 1, cap);
            dp[i][buy][cap] = Math.max(buyStock, skip);
        } else {
            int sell =
                    prices[i] + solve(prices, i + 1, 1, cap - 1);
            int skip =
                    solve(prices, i + 1, 0, cap);
            dp[i][buy][cap] = Math.max(sell, skip);
        }
        return dp[i][buy][cap];
    }
}
//BOTTOM-UP APPROACH
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][][] dp = new int[n + 1][2][3];
//         for (int i = n - 1; i >= 0; i--) {
//             for (int buy = 0; buy <= 1; buy++) {
//                 for (int cap = 1; cap <= 2; cap++) {
//                     if (buy == 1) {
//                         dp[i][buy][cap] = Math.max(
//                                 -prices[i] + dp[i + 1][0][cap],
//                                 dp[i + 1][1][cap]);

//                     } else {
//                         dp[i][buy][cap] = Math.max(
//                                 prices[i] + dp[i + 1][1][cap - 1],
//                                 dp[i + 1][0][cap]);
//                     }
//                 }
//             }
//         }
//         return dp[0][1][2];
//     }
// }
//SPACE-OPTIMIZED DP APPROACH
// class Solution {
//     public int maxProfit(int[] prices) {
//         int[][] ahead = new int[2][3];
//         int[][] curr = new int[2][3];
//         for (int i = prices.length - 1; i >= 0; i--) {
//             for (int buy = 0; buy <= 1; buy++) {
//                 for (int cap = 1; cap <= 2; cap++) {
//                     if (buy == 1) {
//                         curr[buy][cap] = Math.max(
//                                 -prices[i] + ahead[0][cap],
//                                 ahead[1][cap]);
//                     } else {
//                         curr[buy][cap] = Math.max(
//                                 prices[i] + ahead[1][cap - 1],
//                                 ahead[0][cap]);
//                     }
//                 }
//             }
//             ahead = curr;
//             curr = new int[2][3];
//         }
//         return ahead[1][2];
//     }
// }
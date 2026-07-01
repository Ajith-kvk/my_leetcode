
//TOP-DOWN APPROACH(MEMOIZATION)
class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n + 1];
        return solve(n);
    }
    private int solve(int n) {
        if (n <= 2)
            return n;
        if (dp[n] != 0)
            return dp[n];
        dp[n] = solve(n - 1) + solve(n - 2);
        return dp[n];
    }
}
//BOTTOM-UP APPROACH
// class Solution {
//     public int climbStairs(int n) {
//         if (n <= 2)
//             return n;
//         int[] dp = new int[n + 1];
//         dp[1] = 1;
//         dp[2] = 2;
//         for (int i = 3; i <= n; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }
//         return dp[n];
//     }
// }
//SPACE-OPTIMIZED
// class Solution {
//     public int climbStairs(int n) {
//         if (n <= 2)
//             return n;
//         int prev2 = 1;
//         int prev1 = 2;
//         for (int i = 3; i <= n; i++) {
//             int current = prev1 + prev2;
//             prev2 = prev1;
//             prev1 = current;
//         }
//         return prev1;
//     }
// }
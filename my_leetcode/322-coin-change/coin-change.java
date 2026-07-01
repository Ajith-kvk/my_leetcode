//TOP-DOWN APPROACH
class Solution {
    Integer[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[amount + 1];
        int ans = solve(coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int solve(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return Integer.MAX_VALUE;
        if (dp[amount] != null)
            return dp[amount];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = solve(coins, amount - coin);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }
        dp[amount] = min;
        return min;
    }
}
//BOTTOM-UP APPROACH
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int[] dp = new int[amount + 1];
//         Arrays.fill(dp, amount + 1);
//         dp[0] = 0;
//         for (int i = 1; i <= amount; i++) {
//             for (int coin : coins) {
//                 if (i >= coin) {
//                     dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//                 }
//             }
//         }
//         return dp[amount] > amount ? -1 : dp[amount];
//     }
// }
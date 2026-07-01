//BOTTOM-UP APPROACH
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
//TOP-DOWN APPROACH
// class Solution {
//     Integer[] dp;
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         dp = new Integer[n];
//         int ans = 1;
//         for (int i = 0; i < n; i++) {
//             ans = Math.max(ans, solve(nums, i));
//         }
//         return ans;
//     }
//     private int solve(int[] nums, int i) {
//         if (dp[i] != null)
//             return dp[i];
//         int best = 1;
//         for (int j = 0; j < i; j++) {
//             if (nums[j] < nums[i]) {
//                 best = Math.max(best, solve(nums, j) + 1);
//             }
//         }
//         dp[i] = best;
//         return best;
//     }
// }
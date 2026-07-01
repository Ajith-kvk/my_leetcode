//BOTTOM-UP APPROACH
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }
}
//SPACE OPTIMIZATION
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 1)
//             return nums[0];
//         int prev2 = nums[0];
//         int prev1 = Math.max(nums[0], nums[1]);
//         for (int i = 2; i < n; i++) {
//             int curr = Math.max(prev1, nums[i] + prev2);
//             prev2 = prev1;
//             prev1 = curr;
//         }
//         return prev1;
//     }
// }
//TOP-DOWN APPROACH
// class Solution {
//     Integer[] dp;
//     public int rob(int[] nums) {
//         dp = new Integer[nums.length];
//         return solve(nums, 0);
//     }
//     private int solve(int[] nums, int i) {
//         if (i >= nums.length)
//             return 0;
//         if (dp[i] != null)
//             return dp[i];
//         int rob = nums[i] + solve(nums, i + 2);
//         int skip = solve(nums, i + 1);
//         dp[i] = Math.max(rob, skip);
//         return dp[i];
//     }
// }
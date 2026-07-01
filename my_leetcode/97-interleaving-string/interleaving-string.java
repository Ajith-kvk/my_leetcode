//TOP-DOWN APPROACH
class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return solve(s1, s2, s3, 0, 0);
    }
    private boolean solve(String s1, String s2, String s3,
                          int i, int j) {
        if (i == s1.length() && j == s2.length())
            return true;
        if (dp[i][j] != null)
            return dp[i][j];
        int k = i + j;
        boolean ans = false;
        if (i < s1.length() &&
                s1.charAt(i) == s3.charAt(k)) {
            ans |= solve(s1, s2, s3, i + 1, j);
        }
        if (j < s2.length() &&
                s2.charAt(j) == s3.charAt(k)) {
            ans |= solve(s1, s2, s3, i, j + 1);
        }
        dp[i][j] = ans;
        return ans;
    }
}
//BOTTOM-UP APPROACH
// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         int m = s1.length();
//         int n = s2.length();
//         if (m + n != s3.length())
//             return false;
//         boolean[][] dp = new boolean[m + 1][n + 1];
//         dp[0][0] = true;
//         for (int i = 0; i <= m; i++) {
//             for (int j = 0; j <= n; j++) {
//                 if (i > 0 &&
//                         s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
//                     dp[i][j] |= dp[i - 1][j];
//                 }
//                 if (j > 0 &&
//                         s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
//                     dp[i][j] |= dp[i][j - 1];
//                 }
//             }
//         }
//         return dp[m][n];
//     }
// }
//TOP-DOWN APPROACH
class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length() + 1][word2.length() + 1];
        return solve(word1, word2, 0, 0);
    }
    private int solve(String w1, String w2, int i, int j) {
        if (i == w1.length())
            return w2.length() - j;
        if (j == w2.length())
            return w1.length() - i;
        if (dp[i][j] != null)
            return dp[i][j];
        if (w1.charAt(i) == w2.charAt(j)) {
            dp[i][j] = solve(w1, w2, i + 1, j + 1);
        } else {
            int insert = solve(w1, w2, i, j + 1);
            int delete = solve(w1, w2, i + 1, j);
            int replace = solve(w1, w2, i + 1, j + 1);
            dp[i][j] = 1 + Math.min(insert,
                        Math.min(delete, replace));
        }
        return dp[i][j];
    }
}
//BOTTOM-UP APPRAOCH
// class Solution {
//     public int minDistance(String word1, String word2) {
//         int m = word1.length();
//         int n = word2.length();
//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 0; i <= m; i++)
//             dp[i][0] = i;
//         for (int j = 0; j <= n; j++)
//             dp[0][j] = j;
//         for (int i = 1; i <= m; i++) {
//             for (int j = 1; j <= n; j++) {
//                 if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                     dp[i][j] = dp[i - 1][j - 1];
//                 } else {
//                     dp[i][j] = 1 + Math.min(
//                             dp[i][j - 1],
//                             Math.min(dp[i - 1][j],
//                                      dp[i - 1][j - 1]));
//                 }
//             }
//         }
//         return dp[m][n];
//     }
// }
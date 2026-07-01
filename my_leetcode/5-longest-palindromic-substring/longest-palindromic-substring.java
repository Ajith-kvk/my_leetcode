//BOTTOM-UP APPROACH
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLen = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            start = i;
                        }
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
//TOP-BOTTOM APPROACH
// class Solution {
//     Boolean[][] memo;
//     int start = 0;
//     int maxLen = 1;
//     public String longestPalindrome(String s) {
//         int n = s.length();
//         memo = new Boolean[n][n];
//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 if (isPalindrome(s, i, j) && j - i + 1 > maxLen) {
//                     maxLen = j - i + 1;
//                     start = i;
//                 }
//             }
//         }
//         return s.substring(start, start + maxLen);
//     }
//     private boolean isPalindrome(String s, int i, int j) {
//         if (i >= j)
//             return true;
//         if (memo[i][j] != null)
//             return memo[i][j];
//         memo[i][j] = s.charAt(i) == s.charAt(j)
//                 && isPalindrome(s, i + 1, j - 1);
//         return memo[i][j];
//     }
// }
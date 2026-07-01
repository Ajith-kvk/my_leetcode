//TOP-DOWN APPROACH
class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        dp = new Boolean[s.length()];
        return solve(s, 0, set);
    }
    private boolean solve(String s, int start, HashSet<String> set) {
        if (start == s.length())
            return true;
        if (dp[start] != null)
            return dp[start];
        for (int end = start; end < s.length(); end++) {
            String word = s.substring(start, end + 1);
            if (set.contains(word) && solve(s, end + 1, set)) {
                dp[start] = true;
                return true;
            }
        }
        dp[start] = false;
        return false;
    }
}
//BOTTOM-UP APPROACH
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         HashSet<String> set = new HashSet<>(wordDict);
//         int n = s.length();
//         boolean[] dp = new boolean[n + 1];
//         dp[0] = true;
//         for (int i = 1; i <= n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (dp[j] && set.contains(s.substring(j, i))) {
//                     dp[i] = true;
//                     break;
//                 }
//             }
//         }
//         return dp[n];
//     }
// }
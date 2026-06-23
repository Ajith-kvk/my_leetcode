class Solution {
    private static final int MOD = 1_000_000_007;
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        long[] up = new long[m];
        long[] down = new long[m];
        // Length = 1
        for (int i = 0; i < m; i++) {
            up[i] = 1;
            down[i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            long[] prefix = new long[m + 1];
            long[] suffix = new long[m + 1];
            for (int i = 0; i < m; i++) {
                prefix[i + 1] = (prefix[i] + down[i]) % MOD;
            }
            for (int i = m - 1; i >= 0; i--) {
                suffix[i] = (suffix[i + 1] + up[i]) % MOD;
            }
            long[] nextUp = new long[m];
            long[] nextDown = new long[m];
            for (int x = 0; x < m; x++) {
                // Previous value smaller than current
                nextUp[x] = prefix[x];
                // Previous value greater than current
                nextDown[x] = suffix[x + 1];
            }
            up = nextUp;
            down = nextDown;
        }
        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }
        return (int) ans;
    }
}
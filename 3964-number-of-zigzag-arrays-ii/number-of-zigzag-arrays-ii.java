class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int size = 2 * m;

        long[][] T = new long[size][size];
        for (int v = 0; v < m; v++) {
            for (int u = 0; u < v; u++)
                T[u * 2 + 1][v * 2 + 0] = 1;
            for (int u = v + 1; u < m; u++)
                T[u * 2 + 0][v * 2 + 1] = 1;
        }

        long[] init = new long[size];
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < m; b++) {
                if (a < b) init[b * 2 + 0] = (init[b * 2 + 0] + 1) % MOD;
                else if (a > b) init[b * 2 + 1] = (init[b * 2 + 1] + 1) % MOD;
            }
        }

        if (n == 2) {
            long ans = 0;
            for (long x : init) ans = (ans + x) % MOD;
            return (int) ans;
        }

        long[][] Tp = matPow(T, n - 2, size);

        long ans = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                ans = (ans + Tp[i][j] * init[j]) % MOD;

        return (int) ans;
    }

    private long[][] matMul(long[][] A, long[][] B, int sz) {
        long[][] C = new long[sz][sz];
        for (int i = 0; i < sz; i++)
            for (int k = 0; k < sz; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < sz; j++)
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
            }
        return C;
    }

    private long[][] matPow(long[][] M, int p, int sz) {
        long[][] result = new long[sz][sz];
        for (int i = 0; i < sz; i++) result[i][i] = 1;
        while (p > 0) {
            if ((p & 1) == 1) result = matMul(result, M, sz);
            M = matMul(M, M, sz);
            p >>= 1;
        }
        return result;
    }
}
class Solution {
    public int numWays(int n, int k) {
        if (k == 1) {
            if (n <= 2) return 1;
            return 0;
        }
        if (n == 1) return k;
        int[] dp = new int[n + 1];
        dp[1] = k;
        dp[2] = k * k;
        for (int i = 3; i <= n; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }
}

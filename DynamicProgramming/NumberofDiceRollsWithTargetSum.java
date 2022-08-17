class Solution {
    private int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        if (target > n * k) return 0;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                int sum = 0;
                for (int l = 1; l <= k; l++) {
                    if (l > j) continue;
                    sum = (sum + dp[i - 1][j - l]) % mod;
                }
                dp[i][j] = sum % mod;
            }
        }
        return dp[n][target];
    }
}

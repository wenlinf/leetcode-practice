class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int l = 1; l <= k; l++) {
                    if (l == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][l] + costs[i - 1][j - 1]);
                }
            }
        }
        
        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            minCost = Math.min(dp[n][i], minCost);
        }
        return minCost;
    }
}

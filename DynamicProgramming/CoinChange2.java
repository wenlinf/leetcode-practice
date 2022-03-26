class Solution {
    private int[][] dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        this.dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][0] = 1;
        }
        return helper(n - 1, amount, coins);
    }
    
    private int helper(int index, int amount, int[] coins) {
        if (index < 0) {
            return 0;
        }
        if (dp[index][amount] != -1) return dp[index][amount];
        int n = coins.length;
        if (coins[index] > amount) {
            dp[index][amount] = helper(index - 1, amount, coins);
        } else {
            dp[index][amount] = helper(index, amount - coins[index], coins) + helper(index - 1, amount, coins);
        }
        return dp[index][amount];
    }
}

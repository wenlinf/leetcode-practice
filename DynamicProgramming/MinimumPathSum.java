class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        this.grid = grid;
        this.dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return helper(m - 1, n - 1);
    }
    
    private int result;
    private int[][] dp;
    private int[][] grid;
    
    private int helper(int i, int j) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        dp[i][j] = Math.min(helper(i - 1, j), helper(i, j - 1)) +  + grid[i][j];
        // return Math.min(helper(i - 1, j), helper(i, j - 1)) +  + grid[i][j];
        return dp[i][j];
    }
}

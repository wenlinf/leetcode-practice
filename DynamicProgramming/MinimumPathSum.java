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


// bottom up
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grid[0][i];
            dp[0][i] = sum;
        }
        sum = 0;
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}

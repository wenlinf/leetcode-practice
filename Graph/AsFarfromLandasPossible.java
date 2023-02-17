class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int landCount = 0;
        int[][] dp = new int[m][n];
        int maxVal = n + m + 1;
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], maxVal);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0; 
                } else {
                    int top = i > 0 ? dp[i - 1][j] : maxVal;
                    int left = j > 0 ? dp[i][j - 1] : maxVal;
                    dp[i][j] = Math.min(dp[i][j], Math.min(left, top) + 1);
                }          
            }
        }
        int max = -1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                    int bottom = i < m - 1 ? dp[i + 1][j] : maxVal;
                    int right = j < n - 1 ? dp[i][j + 1] : maxVal;
                    dp[i][j] = Math.min(dp[i][j], Math.min(bottom, right) + 1);
                    max = Math.max(max, dp[i][j]);
            }  
        }
        return max == maxVal || max == 0 ? -1 : max;
    }
}

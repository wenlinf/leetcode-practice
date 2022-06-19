class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int result = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < rows; i++) {
            result = Math.min(result, helper(matrix, rows - 1, i, dp));
        }
        return result;
    }
    
    private int helper(int[][] matrix, int i, int j, int[][] dp) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return Integer.MAX_VALUE;
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        
        int result = Integer.MAX_VALUE;
        if (i == 0) {
            return matrix[i][j];
        }
        result = Math.min(result, helper(matrix, i - 1, j, dp));
        result = Math.min(result, helper(matrix, i - 1, j + 1, dp));
        result = Math.min(result, helper(matrix, i - 1, j - 1, dp));
        result += matrix[i][j];
        dp[i][j] = result;
        return result;
    }
}


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        int[][] dp = new int[n + 1][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], 
                                        dp[i - 1][j + 1]) + matrix[i - 1][j];
                } else if (j == n - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], 
                                        dp[i - 1][j]) + matrix[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], 
                                        Math.min(dp[i - 1][j], 
                                                 dp[i - 1][j + 1])) + matrix[i - 1][j];
                }

            }
        }
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            best = Math.min(best, dp[n][i]);
        }
        return best;
    }
}

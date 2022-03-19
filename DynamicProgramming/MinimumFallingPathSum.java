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

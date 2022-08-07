class Solution {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m;
    private int n;
    private int[][] cache;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] result = new int[m][n];
        this.cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], 1);
            Arrays.fill(cache[i], -1);
            
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, matrix, result);
            }
        }
        
        int longest = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longest = Math.max(longest, result[i][j]);
            }
        }
        return longest;
    }
    
    private int dfs(int i, int j, int[][] matrix, int[][] result) {
        if (cache[i][j] != -1) return cache[i][j];
        int longest = 0;
        for (int[] direction : directions) {
            int x = direction[0];
            int y = direction[1];
            int row = x + i;
            int col = y + j;
            if (row >= 0 && col >= 0 && row < m && col < n) {
                if (matrix[i][j] < matrix[row][col]) {
                    longest = Math.max(longest, dfs(row, col, matrix, result));
                }
            }
        }
        result[i][j] = longest + 1;
        cache[i][j] = result[i][j];
        return result[i][j];
    }
}

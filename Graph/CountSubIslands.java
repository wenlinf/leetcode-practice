class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] == 0) {
                    dfs(grid2, i, j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] == 1) {
                    dfs(grid2, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 0) return;
        grid[i][j] = 0;
        for (int[] dir : directions) {
            int x = dir[0];
            int y = dir[1];
            int row = x + i;
            int col = y + j;
            dfs(grid, row, col);
        }
    }
}

class Solution {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numEnclaves(int[][] grid) {
        /**
        traverse the edge of the grid
        if the cell is 1 traverse all it's neighbors and mark them all as 0
        traver the grid again, count the number of 1s left in the grid
         */
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    // at the edge, if cell is 1, start DFS
                    if (grid[i][j] == 1) {
                        dfs(grid, i, j);
                    }
                } 
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int[] direction : directions) {
            int x = direction[0];
            int y = direction[1];
            int row = i + x;
            int col = y + j;
            if (row >= 0 && row < m && col >= 0 && col < n) {
                if (grid[row][col] == 1) {
                    dfs(grid, row, col);
                } 
            }
        }
    }
}

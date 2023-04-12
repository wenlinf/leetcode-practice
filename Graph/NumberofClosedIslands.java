class Solution {
    public int closedIsland(int[][] grid) {
        /**
        traverse the border cells first, if there's 0, DFS and change them all to 1
        traverse the other cells, if 0, DFS, increase count
         */
         int m = grid.length;
         int n = grid[0].length;
         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (grid[i][j] == 0) {
                        dfs(grid, i, j);
                    }
                }
            }
         }
         int res = 0;
         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 if (grid[i][j] == 0) {
                     dfs(grid, i, j);
                     res++;
                 }
             }
         }
         return res;
    }

    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(int[][] grid, int i, int j) {
        grid[i][j] = 1;
        int m = grid.length;
        int n = grid[0].length;
        for (int[] direction : directions) {
            int x = direction[0];
            int y = direction[1];
            int row = i + x;
            int col = j + y;
            if (row >= 0 && row < m && col >= 0 && col < n) {
                if (grid[row][col] == 0) {
                    dfs(grid, row, col);
                }
            }
        }
    }
}

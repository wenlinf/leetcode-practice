class Solution {
    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        dfs(grid, row, col, grid[row][col], color, visited);
        return grid;
    }

    private int dfs(int[][] grid, int i, int j, int origColor, int color, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1) {
            return 0;
        }
        if (visited[i][j]) return 1;
        if (grid[i][j] != origColor) return 0;
        visited[i][j] = true;
        int sum = 0;
        for (int[] dir : directions) {
            int x = dir[0];
            int y = dir[1];
            int row = x + i;
            int col = y + j;
            sum += dfs(grid, row, col, origColor, color, visited);
        }
        if (sum < 4) {
            grid[i][j] = color;
        }
        return 1;
    }
}

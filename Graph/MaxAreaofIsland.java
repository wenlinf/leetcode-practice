class Solution {
    private int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    this.area = 1;
                    dfs(grid, i, j);
                }
            }
        }
        return maxArea;
    }
    
    private int maxArea = 0;
    private int area = 0;
    private void dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        maxArea = Math.max(maxArea, area);
        for (int[] direction : directions) {
            int newX = direction[0] + i;
            int newY = direction[1] + j;
            if (newX < 0 || newY < 0 
                || newX >= grid.length 
                || newY >= grid[0].length) {
                continue;
            }
            if (grid[newX][newY] == 1) {
                area++;
                maxArea = Math.max(maxArea, area);
                dfs(grid, newX, newY); 
            }
        }
    }
}

class Solution {
    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, -1);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb, int direction) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 0) return;
        grid[i][j] = 0;
        sb.append(direction).append(",");
        for (int l = 0; l < 4; l++) {
            int[] dir = directions[l];
            int x = dir[0];
            int y = dir[1];
            int row = x + i;
            int col = y + j;
            dfs(grid, row, col, sb, l);
        } 
        sb.append(-direction).append(",");
    }
}

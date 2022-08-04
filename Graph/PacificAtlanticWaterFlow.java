class Solution {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        int[][] visitedPacific = new int[m][n];
        int[][] visitedAtlantic = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dfs(i, j, heights, pacific, visitedPacific, m, n);
                }
                if (i == m - 1 || j == n - 1) {
                    dfs(i, j, heights, atlantic, visitedAtlantic, m, n);
                }
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return result;
    }
    
    private void dfs(int i, int j, int[][] heights, boolean[][] reachable, int[][] visited, int m, int n) {
        if (i >= m || i < 0 || j >= n || j < 0) return;
        visited[i][j] = 1;
        reachable[i][j] = true;
        
        for (int[] direction : directions) {
            int x = direction[0];
            int y = direction[1];
            int row = x + i;
            int col = y + j;
            if (row >= 0 && col >= 0 && row < m && col < n) {
                if (heights[row][col] >= heights[i][j] && visited[row][col] == 0) {
                    dfs(row, col, heights, reachable, visited, m, n);
                }
            }
        }
    }
}

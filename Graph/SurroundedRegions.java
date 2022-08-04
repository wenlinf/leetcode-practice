class Solution {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] safe = new boolean[m][n];
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (board[i][j] == 'O'  && visited[i][j] == 0) {
                        dfs(i, j, board, m, n, safe, visited);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !safe[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void dfs(int i, int j, char[][] board, int m, int n, boolean[][] safe, int[][] visited ) {
        visited[i][j] = 1;
        if (board[i][j] == 'O') {
            safe[i][j] = true;
        }
        for (int[] direction : directions) {
            int x = direction[0];
            int y = direction[1];
            int row = x + i;
            int col = y + j;
            if (row < m && col < n && row >= 0 && col >= 0) {
                if (board[row][col] == 'O' && visited[row][col] == 0) {
                    dfs(row, col, board, m, n, safe, visited);
                }
            }
        }
    }
}

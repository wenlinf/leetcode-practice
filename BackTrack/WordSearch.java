class Solution {
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }  
    
    private boolean dfs(char[][] board, String word, int index, int row, int col) {
        if (index >= word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        
        if (word.charAt(index) != board[row][col]) return false;
        for (int i = 0; i < 4; i++) {
            int[] direction = directions[i];
            int x = direction[0];
            int y = direction[1];
            int nextRow = row + x;
            int nextCol = col + y;
            char temp = board[row][col];
            board[row][col] = '1';
            if (dfs(board, word, index+1, nextRow, nextCol)) return true;
            board[row][col] = temp;
        }
        return false;
    }
}

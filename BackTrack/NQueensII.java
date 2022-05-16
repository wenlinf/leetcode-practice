class Solution {
    public int totalNQueens(int n) {
        this.size = n;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, 0);
        return count;
    }
    
    private int count;
    private int size;
    
    private void backtrack(char[][] board, int row) {
        if (row == size) {
            count++;
            return;
        }
        for (int i = 0; i < size; i++) {
            if (!isValid(i, row, board)) {
                continue;
            }
            board[row][i] = 'Q';
            backtrack(board, row + 1);
            board[row][i] = '.';
        }
    }
    
    private boolean isValid(int col, int row, char[][] board) {
    for (int i = 0; i < row; i++) {
      if (board[i][col] == 'Q') {
        return false;
      }
    }
    for (int i = row - 1, j = col + 1; i >= 0 && j < size; i--, j++) {
        if (board[i][j] == 'Q') {
          return false;
      }
    }
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] == 'Q') {
          return false;
      }
    }
    return true;
  }
}

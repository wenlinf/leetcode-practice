class Solution {
    private char[][] board;
     
    public void solveSudoku(char[][] board) {
        this.board = board;
        backtrack(0, 0);
    }
    
    private boolean backtrack(int row, int col) {
        if (col == 9) {
            col = 0;
            row++;
        }
        if (row == 9) {
            return true;
        }
        if (board[row][col] != '.') {
            return backtrack(row, col + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            if (!isValid(row, col, ch)) {
                continue;
            } else {
                board[row][col] = ch;
                if (backtrack(row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    
    private boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
            if (board[i][col] == num) {
                return false;
            }
        }

        int rowSec = row / 3;
        int colSec = col / 3;
        
        for (int i = rowSec * 3; i < rowSec * 3 + 3; i++) {
            for (int j = colSec * 3; j < colSec * 3 + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}

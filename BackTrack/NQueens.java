class Solution {
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.n = n;
        this.row = 0;
        char[][] board = new char[n][n];
        backtrack(board);
        return result;
    }
    
    private List<List<String>> result;
    private int n;
    private int row;
    
    private List<String> createBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
    
    private void backtrack(char[][] board) {
        if (row == n) {
            result.add(createBoard(board));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!isValid(i, board)) {
                continue;
            }
            board[row][i] = 'Q';
            row++;
            backtrack(board);
            row--;
            board[row][i] = '.';
        }
    }
    
    private boolean isValid(int col, char[][] board) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col + 1; j < n; j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }
}

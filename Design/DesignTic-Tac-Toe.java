class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
    }
    
    public int move(int row, int col, int player) {
        int val = player == 1 ? 1 : -1;
        this.rows[row] += val;
        this.cols[col] += val;
        if (row == col) this.diagonal+= val;
        if (col == (cols.length - row - 1)) {
            this.antiDiagonal += val;
        }
        int n = rows.length;
        if (Math.abs(rows[row]) == n 
           || Math.abs(cols[col]) == n
           || Math.abs(antiDiagonal) == n 
           || Math.abs(diagonal) == n) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> columnMap = new HashMap<>();
        Map<Integer, Set<Character>> boxMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (i % 3 == 0 && j == 0)  boxMap = new HashMap<>();
                if (board[i][j] != '.') {
                    //check if element is in row
                    if (rowSet.contains(board[i][j])) return false;
                    rowSet.add(board[i][j]);
                    //check if element is in column
                    if (!columnMap.containsKey(j)) {
                        columnMap.put(j, new HashSet<Character>());     
                    } else {
                        if (columnMap.get(j).contains(board[i][j])) return false;
                    }
                    columnMap.get(j).add(board[i][j]);
                    //check if element is in sub-box
                    if (!boxMap.containsKey(j / 3)) {
                        boxMap.put(j/3, new HashSet<Character>());
                    }
                    else {
                        if (boxMap.get(j / 3).contains(board[i][j])) return false;
                    }
                    boxMap.get(j / 3).add(board[i][j]);
                }
            }
        }
        return true;
    }
}

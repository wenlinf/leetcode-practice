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

// 2020-05-27
class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> columnList = new ArrayList<>();

        List<Set<Character>> secList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            columnList.add(new HashSet<>());
            secList.add(new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            char[] row = board[i];
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (row[j] == '.') continue;
                if (rowSet.contains(row[j])) return false;
                
                if (columnList.size() != 0 && columnList.get(j).size() != 0 && columnList.get(j).contains(row[j])) return false;
                if (secList.get((i / 3) * 3 + j /3).contains(row[j])) return false;
                rowSet.add(row[j]);
                columnList.get(j).add(row[j]);
                secList.get((i / 3) * 3 + j/3).add(row[j]);
            }
        }
        return true;
    }
}

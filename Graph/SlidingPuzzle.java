class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] neighbors = new int[][]{{1, 3}, 
                                        {0, 2, 4}, 
                                        {1, 5},
                                        {0, 4},
                                        {1, 3, 5},
                                        {2, 4}};
        String target = "123450";
        
        StringBuilder sb = new StringBuilder();
        LinkedList<String> queue = new LinkedList<>();
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        String first = sb.toString();
        queue.add(sb.toString());
        Set<String> visited = new HashSet<>();
        int moves = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                String start = queue.poll();
                if (start.equals(target)) return moves;
                visited.add(start);
                int indexOfZero = start.indexOf('0');
                int[] nextMoves = neighbors[indexOfZero];
                for(int move : nextMoves) {
                    char[] currChars = start.toCharArray();
                    currChars[indexOfZero] = start.charAt(move);
                    currChars[move] = '0';
                    if (!visited.contains(String.valueOf(currChars))) {
                        queue.add(String.valueOf(currChars));
                    }
                }
                levelSize--;
            }
            moves++;
        }
        return -1;
    }
}

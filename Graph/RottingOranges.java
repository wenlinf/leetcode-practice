class Solution {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        boolean[][] visited = new boolean[m][n];
        
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair<>(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        if (queue.size() == 0) return -1;
        int time = -1;
        while (queue.size() != 0) {
            int levelSize = queue.size();
            time++;
            while (levelSize > 0) {
                levelSize--;
                Pair<Integer, Integer> orange = queue.poll();
                int i = orange.getKey();
                int j = orange.getValue();
                visited[i][j] = true;
                for (int[] direction : directions) {
                    int x = direction[0];
                    int y = direction[1];
                    int row = i + x;
                    int col = j + y;
                    if (row < m && col < n && row >= 0 && col >= 0) {
                        if (grid[row][col] == 1) {
                            fresh--;
                            grid[row][col] = 2;
                            queue.add(new Pair<>(row, col));
                        } 
                    }
                }
            }
            
        }
        return fresh == 0 ? time : -1;
    }
}

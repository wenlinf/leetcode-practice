class NumberOfIslands {
    private int[][] directions = new int[][]{{0,1}, {0, -1}, {-1, 0}, {1, 0}};
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int cellRow = cell[0];
                        int cellCol = cell[1];
                        grid[cellRow][cellCol] = '0';
                        List<List<Integer>> neighbors = getNeighbors(cellRow, cellCol, grid);
                        for (List<Integer> neighbor: neighbors) {
                            if (grid[neighbor.get(0)][neighbor.get(1)] == '1') {
                                queue.add(new int[]{neighbor.get(0), neighbor.get(1)});
                                grid[neighbor.get(0)][neighbor.get(1)] = '0'; //this line?
                            }
                        }
                    }
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    
    private List<List<Integer>> getNeighbors(int x, int y, char[][] grid) {
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < directions.length; i++) {
            int row = x + directions[i][0];
            int col = y + directions[i][1];
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
                List<Integer> neighbor = new ArrayList<>();
                neighbor.add(row);
                neighbor.add(col);
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }
}

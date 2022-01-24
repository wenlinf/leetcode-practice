class ShortestPathinBinaryMatrix {
    private static final int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid.length - 1] != 0) return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int distance = grid[cell[0]][cell[1]];
            if (cell[0] == grid.length - 1 && cell[1] == grid.length - 1) {
                    return distance;    
            }
            List<List<Integer>> neighbors = getNeighbors(cell[0], cell[1], grid);
            for (List<Integer> neighbor : neighbors) {
                if (grid[neighbor.get(0)][neighbor.get(1)] == 0) {
                    grid[neighbor.get(0)][neighbor.get(1)] = distance + 1;
                    queue.add(new int[] {neighbor.get(0), neighbor.get(1)});
                }                
            }
        }
        return -1;
    }
    
    public List<List<Integer>> getNeighbors(int row, int col, int[][] grid) {
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < directions.length; i++) {
            int neighborRow = row + directions[i][0];
            int neighborCol = col + directions[i][1];
            if (neighborRow >= 0 && neighborCol >= 0 && neighborRow < grid.length 
               && neighborCol < grid.length) {
                List<Integer> neighbor = new ArrayList<>();
                neighbor.add(neighborRow);
                neighbor.add(neighborCol);
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }
}

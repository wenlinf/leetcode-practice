class WallsAndGates {
    private static final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    // bfs(i, j, rooms);
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int cellRow = cell[0];
            int cellCol = cell[1];
            
            List<List<Integer>> neighbors = getNeighbors(cell[0], cell[1], rooms);
            
            for (List<Integer> neighbor: neighbors) {
                int row = neighbor.get(0);
                int col = neighbor.get(1);
                if (rooms[row][col] != Integer.MAX_VALUE) continue;
                if (rooms[row][col] != 0 && rooms[row][col] != -1) {
                    rooms[row][col] =  rooms[cellRow][cellCol] + 1;
                    queue.add(new int[]{row, col});       
                }
            }
        }
    }
    
    
    public List<List<Integer>> getNeighbors(int x, int y, int[][] rooms) {
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < directions.length; i++) {
            int neighborRow = x + directions[i][0];
            int neighborCol = y + directions[i][1];
            if (neighborRow >= 0 
                && neighborCol >= 0 
                && neighborRow < rooms.length
                && neighborCol < rooms[0].length) {
                List<Integer> neighbor = new ArrayList<>();
                neighbor.add(neighborRow);
                neighbor.add(neighborCol);
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }
}

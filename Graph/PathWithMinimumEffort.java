//Brute Force backtracking TLE
class Solution {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        this.minEffort = Integer.MAX_VALUE;
        int currEffort = 0;
        Set<List<Integer>> visited = new HashSet<>();
        dfs(heights, m, n, 0, 0, visited, currEffort);
        return minEffort;
    }
    
    private int minEffort;
    private void dfs(int[][] heights, int m, int n, int i, int j, Set<List<Integer>> visited, int currEffort) {
        if (i == m - 1 && j == n - 1) {
            minEffort = Math.min(minEffort, currEffort);
            currEffort = 0;
            return;
        }
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        visited.add(list);
        for (int[] direction : directions) {
            int x = direction[0];
            int y = direction[1];
            int row = i + x;
            int col = j + y;
            if (row >= 0 && row < m && col >= 0 && col < n) {
                List<Integer> currList = new ArrayList<>();
                currList.add(row);
                currList.add(col);
                if (visited.contains(currList)) continue;
                int temp = currEffort;
                currEffort = Math.max(currEffort, Math.abs(heights[row][col] - heights[i][j]));
                dfs(heights, m, n, row, col, visited,currEffort);
                currEffort = temp;
            }
        }
        visited.remove(list);
    }
}


// Dijkstra's
class Solution {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] efforts = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            int i = first[0];
            int j = first[1];
            int effort = first[2];
            for (int[] direction : directions) {
                int x = direction[0];
                int y = direction[1];
                int row = x + i;
                int col = y + j;
                if (row >= 0 && col >= 0 && row < m && col < n) {
                    if (efforts[row][col] > Math.max(effort, Math.abs(heights[row][col] - heights[i][j]))) {
                        efforts[row][col] = Math.max(effort, Math.abs(heights[row][col] - heights[i][j]));
                        pq.offer(new int[]{row, col, efforts[row][col]});
                    }  
                }
            }
        }
        return efforts[m - 1][n - 1];
    }
}

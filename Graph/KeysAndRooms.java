class Solution {
    private static int WHITE = 1;
    private static int GRAY = 2;
    private static int BLACK = 3;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int[] color = new int[n];
        Arrays.fill(color, WHITE);
        int[] visited = new int[n];
        dfs(0, rooms, n, color, visited);
        for (int visit : visited) {
            if (visit == 0) return false;
        }
        return true;
    }
    
    private void dfs(int start, List<List<Integer>> rooms, int n, int[] color, int[] visited) {
        List<Integer> neighbors = rooms.get(start);
        color[start] = GRAY;
        visited[start] = 1;
        for(int neighbor : neighbors) {
            if (color[neighbor] == WHITE) {
                visited[neighbor] = 1;
                dfs(neighbor, rooms, n, color, visited);
            }
        }
    }
}

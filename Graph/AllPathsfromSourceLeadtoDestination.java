class Solution {
    private static int WHITE = 1;
    private static int GRAY = 2;
    private static int BLACK = 3;
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> color = new HashMap<>();
        for (int i = 0; i < n; i++) {
            color.put(i, WHITE);
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (!adjList.containsKey(from)) {
                adjList.put(from, new ArrayList<>());
            }
            adjList.get(from).add(to);
        }
        dfs(source, destination, adjList, color);
        if (hasCycle) return false;
        if (endsInAnother) return false;
        return true;
    }
    
    private boolean hasCycle;
    private boolean endsInAnother;
    private void dfs(int source, int destination, Map<Integer, List<Integer>> adjList, Map<Integer, Integer> color) {
        if (hasCycle || endsInAnother) return;
        color.put(source, GRAY);
        if (adjList.containsKey(source)) {
            for (int neighbour : adjList.get(source)) {
                if (color.get(neighbour) == GRAY) {
                    this.hasCycle = true;
                    return;
                }
                if (color.get(neighbour) == WHITE) {
                    dfs(neighbour, destination, adjList, color);
                }
            }
        } else {
            if (source != destination) endsInAnother = true;
        }
        color.put(source, BLACK);
    }
}

class Solution {
    private static int WHITE = -1;
    private static int GRAY = 1;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> color = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] neighbors = graph[i];
            adjList.put(i, new ArrayList<>());
            for (int j = 0; j < neighbors.length; j++) {
                adjList.get(i).add(neighbors[j]);
            }
        }
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, graph, adjList, color, visited, WHITE)) return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int i, 
                        int[][] graph, 
                        Map<Integer, List<Integer>> adjList, 
                        Map<Integer, Integer> color, 
                        int[] visited, 
                        int currColor) {
        visited[i] = 1;
        color.put(i, currColor);
        if (adjList.containsKey(i)) {
            List<Integer> neighbours = adjList.get(i);
            for (int neighbor : neighbours) {
                if (visited[neighbor] == 1 && color.get(neighbor) == currColor) return false;
                if (visited[neighbor] == 0) {
                    if(!dfs(neighbor, graph, adjList, color, visited, -currColor)) return false;
                }
            }
        }
        return true;
    }
}

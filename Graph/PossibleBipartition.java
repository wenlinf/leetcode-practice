class Solution {
    private static int WHITE = 1;
    private static int BLACK = -1;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] dislike : dislikes) {
            int from = dislike[0];
            int to = dislike[1];
            if (!adjList.containsKey(from)) {
                adjList.put(from, new ArrayList<>());
            }
            if (!adjList.containsKey(to)) {
                adjList.put(to, new ArrayList<>());
            }
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        int[] colors = new int[n + 1];
        int[] visited = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            if(visited[i] == 1) continue;
            if (!dfs(i, colors, adjList, visited, WHITE)) return false;
        }
        return true;
    }
    
    private boolean dfs(int i, int[] colors, Map<Integer, List<Integer>> adjList, int[] visited, int color) {
        if (!adjList.containsKey(i)) return true;
        visited[i] = 1;
        colors[i] = color;
        List<Integer> neighbors = adjList.get(i);
        for (int neighbor : neighbors) {
            if (visited[neighbor] == 0) {
                dfs(neighbor, colors, adjList, visited, -color);
            } else {
                if (colors[neighbor] == colors[i]) return false;
            }
        }
        return true;
    }
}

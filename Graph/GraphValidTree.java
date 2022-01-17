class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        List<Integer>[] adjList = new ArrayList[n];
        int[] visited = new int[n];
        int components = 0;
        
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        dfs(adjList, visited, 0);
        
        
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) return false;
        }
        return true;
    }
    
    public void dfs(List<Integer>[] adjList, int[] visited, int startNode) {
        visited[startNode] = 1;
        
        for (int i = 0; i < adjList[startNode].size(); i++) {
            if (visited[adjList[startNode].get(i)] == 0) {
                dfs(adjList, visited, adjList[startNode].get(i));
            }
        }
    }
}

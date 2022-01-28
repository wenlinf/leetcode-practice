class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0) {
            if (n == 1) return true;
            return false;
        }
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            if (!adjMap.containsKey(edges[i][0])) {
                adjMap.put(edges[i][0], new ArrayList<Integer>());
            }
            adjMap.get(edges[i][0]).add(edges[i][1]);
            if (!adjMap.containsKey(edges[i][1])) {
                adjMap.put(edges[i][1], new ArrayList<Integer>());
            }
            adjMap.get(edges[i][1]).add(edges[i][0]);
        }
        boolean result = dfs(source, destination, adjMap, visited);
        return result;
    }
    
    public boolean dfs(int src, int target, Map<Integer, List<Integer>> adjMap, Set<Integer> visited) {
        visited.add(src);
        if (adjMap.get(src).contains(target)) return true;
        for (int i = 0; i < adjMap.get(src).size(); i++) {
            if (visited.contains(adjMap.get(src).get(i))) continue;
            if (dfs(adjMap.get(src).get(i), target, adjMap, visited)) return true;
        }
        return false;
    }
}
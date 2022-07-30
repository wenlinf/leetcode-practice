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


class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }
            if (!graph.containsKey(to)) {
                graph.put(to, new ArrayList<>());
            }
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        boolean[] visited = new boolean[n];
        dfs(source, destination, graph, visited);
        return exists;
    }
    
    private boolean exists = false;
    
    private void dfs(int start, int destination, Map<Integer, List<Integer>> graph, boolean[] visited) {
        if (visited[start]|| exists) {
            return;
        }
        visited[start] = true;
        List<Integer> neighbours = graph.get(start);
        for (int neighbour : neighbours) {
            if (neighbour == destination) {
                exists = true;
                return;
            }
            if (!visited[neighbour]) {
                dfs(neighbour, destination, graph, visited);
            }        
        }
        // visited.removeLast();
    }
}

// solution using stack
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }
            if (!graph.containsKey(to)) {
                graph.put(to, new ArrayList<>());
            }
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        boolean[] visited = new boolean[n];
        while (!stack.isEmpty()) {
            int top = stack.pop();
            visited[top] = true;
            List<Integer> adjList = graph.get(top);
            for (int neighbour : adjList) {
                if (neighbour == destination) return true;
                if (!visited[neighbour]) stack.push(neighbour);
            }
        }
        return false;
    }
}

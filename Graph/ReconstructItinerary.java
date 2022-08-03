class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adjList = new HashMap<>(); 
        Map<String, boolean[]> visited = new HashMap<>(); 
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!adjList.containsKey(from)) {
                adjList.put(from, new ArrayList<>());
            }
            adjList.get(from).add(to);
        }
        List<String>result = new ArrayList<>();
        List<List<String>> allPaths = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: adjList.entrySet()) {
            Collections.sort(entry.getValue());
            visited.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }
        LinkedList<String> path = new LinkedList<>();
        route = new LinkedList<>();
        dfs("JFK", adjList, path, tickets.size() + 1, visited);
        
        return route;
    }
    
    private LinkedList<String> route;
    private void dfs(String start, Map<String, List<String>> adjList, LinkedList<String> path, int n, Map<String, boolean[]> visited) {
        path.add(start);
        if (path.size() == n) {
            route.addAll(path);
            return;
        }
        if (adjList.containsKey(start)) {
            List<String> neighbours = adjList.get(start);
            for (int i = 0; i < neighbours.size(); i++) {
                if (visited.get(start)[i] == true) continue;
                visited.get(start)[i] = true;
                String neighbour = neighbours.get(i);
                dfs(neighbour, adjList, path, n, visited);
                if (path.size() == n) return;
                visited.get(start)[i] = false;
            }
        }
        path.removeLast();
    }
}

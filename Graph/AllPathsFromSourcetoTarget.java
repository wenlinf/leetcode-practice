class AllPathsFromSourcetoTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> stack = new ArrayList<>();
        
        for (int i = 0; i < graph[0].length; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(0);
            path.add(graph[0][i]);
            stack.add(path);
        }
        
        visited.add(0);
        while (stack.size() != 0){
            List<Integer> pop = stack.remove(stack.size() - 1);
            if (!visited.contains(pop.get(pop.size() - 1))) {
                visited.add(pop.get(pop.size() - 1));
                for (int i = 0; i < graph[pop.get(pop.size() - 1)].length; i++) {
                        pop.add(graph[pop.get(pop.size() - 1)][i]);
                        List<Integer> pathCopy = new ArrayList<>();
                        for (int j = 0; j < pop.size(); j++) {
                            pathCopy.add(pop.get(j));
                        }
                        stack.add(pathCopy);
                        pop.remove(pop.size() - 1); 
                    }
                if (pop.get(pop.size() - 1) == graph.length - 1) {
                    List<Integer> pathCopy = new ArrayList<>();
                    for (int i = 0; i < pop.size(); i++) {
                        pathCopy.add(pop.get(i));
                    }
                    result.add(pathCopy);
                    visited.clear();
                    continue;
                }              
            }
        }
        return result;
    }    
}


class Solution {
    private static int WHITE = 1;
    private static int GRAY = 2;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, Integer> color = new HashMap<>(); 
        for (int i = 0; i < graph.length; i++) {
            color.put(i, WHITE);
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, graph, result, new LinkedList<>(), color);
        return result;
    }
    
    private void dfs(int start, int[][] graph, List<List<Integer>> result, LinkedList<Integer> path, Map<Integer, Integer> color) {
        if (color.get(start) == WHITE) {
            color.put(start, GRAY);
            path.add(start);
            if (start == graph.length - 1) {
                result.add(new LinkedList<>(path));
            }
            int[] neighbours = graph[start];
            for (int neighbour : neighbours) {
                dfs(neighbour, graph, result, path, color);
            }
            path.removeLast();
            
            color.put(start, WHITE);
        }
    }
}

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

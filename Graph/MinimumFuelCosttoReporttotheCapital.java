class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0) return 0;
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            if (!adjMap.containsKey(from)) {
                adjMap.put(from, new ArrayList<>());
            }
            if (!adjMap.containsKey(to)) {
                adjMap.put(to, new ArrayList<>());
            }
            adjMap.get(from).add(to);
            adjMap.get(to).add(from);
        }
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> subTreeSize = new HashMap<>();
        dfs(seats, adjMap, -1, 0);
        return fuel;
    }

    private long fuel;

    private int dfs(int seats, Map<Integer, List<Integer>> adjMap, int parent, int start) {
        // if (!adjMap.containsKey(start)) return 0;
        List<Integer> neighbors = adjMap.get(start);
        int subTreeSum = 1;
        for (int i = 0; i < neighbors.size(); i++) {
            int neighbor = neighbors.get(i);
            if (neighbor != parent) {
                int subSize = dfs(seats, adjMap, start, neighbor);
                subTreeSum += subSize;
            }
        }
        if (start != 0){
            fuel += Math.ceil((double) subTreeSum / seats); 
        }
        return subTreeSum;
        
        
    }
}

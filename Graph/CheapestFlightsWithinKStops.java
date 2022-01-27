class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] costs = new int[k + 2][n];
         Map <Integer, List<int[]>> adjMap = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            int[] flight = flights[i];
            if (!adjMap.containsKey(flight[1])) {
                adjMap.put(flight[1], new ArrayList<>());
            }
            adjMap.get(flight[1]).add(new int[]{flight[0], flight[2]});
        }
        for (int i = 0; i < costs.length; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < k + 2; i++) {
            costs[i][src] = 0; 
        }
        for (int i = 1; i < k + 2; i++) {
            for (int j = 0; j < n; j++) {
                List<int[]> parents = adjMap.get(j);
                int minCost = costs[i][j];
                if (parents == null) continue;
                for (int[] parent: parents) {
                    if (costs[i - 1][parent[0]] != Integer.MAX_VALUE) {
                        minCost = Math.min(minCost, costs[i - 1][parent[0]] + parent[1]);   
                    }
                } 
                costs[i][j] = minCost;
            }
        }
        if (costs[k + 1][dst] == Integer.MAX_VALUE) return -1;
        return costs[k + 1][dst];
    }
}

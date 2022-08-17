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


// Dijkstra's
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            if (!adjList.containsKey(from)) {
                adjList.put(from, new ArrayList<>());
            }
            adjList.get(from).add(new int[]{to, price});
        }
        int[] curr = new int[n];
        int[] currStops = new int[n];
        Arrays.fill(curr, Integer.MAX_VALUE);
        curr[src] = 0;
        Arrays.fill(currStops, Integer.MAX_VALUE);
        currStops[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        pq.offer(new int[]{src, 0, 0}); // index, price, stops
        
        while (!pq.isEmpty()) {
            int[] start = pq.poll();
            int index = start[0];
            int cost = start[1];
            int stops = start[2]; 
            if (index == dst) return cost;
            if (stops == k + 1) continue;
            if (adjList.containsKey(index)) {
                List<int[]> neighbors = adjList.get(index);
                for (int[] neighbor : neighbors) {
                    int neighborIndex = neighbor[0];
                    int neighborCost = neighbor[1];
                    if (curr[neighborIndex] > neighborCost + cost) {
                        curr[neighborIndex] = neighborCost + cost;
                        currStops[neighborIndex] = stops;
                        pq.offer(new int[]{neighborIndex, curr[neighborIndex], stops + 1});
                    } else if (stops < currStops[neighborIndex]) {
                        pq.offer(new int[]{neighborIndex, neighborCost + cost, stops + 1});
                    }
                }
            }
        }
        return curr[dst] == Integer.MAX_VALUE ? -1 : curr[dst];
    }
}

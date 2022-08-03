class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        if (n == 1) return 0;
        
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];
            if (!adjMap.containsKey(time[0])) {
                adjMap.put(time[0], new ArrayList<>());
            }
            adjMap.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        Set<Integer> visited = new HashSet<>();
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[k] = 0;
        

        while(true) {
            //find the node with the least distance and traverse its neighbors
            int candidate = -1;
            int candDistance = Integer.MAX_VALUE;
            for (int i = 1; i < n+1; i++) {
                if (cost[i] < candDistance && !visited.contains(i)) {
                    candDistance = cost[i];
                    candidate = i;
                }
            }
            if (candidate == -1) break;
            visited.add(candidate);
            List<int[]> neighbors = adjMap.get(candidate);
            if (adjMap.containsKey(candidate)) {
                for (int[] neighbor: neighbors) {
                    if (!visited.contains(neighbor[0])) {
                        if (candDistance + neighbor[1] < cost[neighbor[0]]) {
                            cost[neighbor[0]] = candDistance + neighbor[1];
                        }
                    }     
                }
            }
        }
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            if (cost[i] > result) {
                if (cost[i] == Integer.MAX_VALUE) return -1;
                result = cost[i];
            }
        }
        return result;         
    }
}

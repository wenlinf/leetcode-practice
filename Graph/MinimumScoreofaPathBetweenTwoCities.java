class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<Pair<Integer, Integer>>> adjMap = new HashMap<>();
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            int dist = road[2];
            if (!adjMap.containsKey(from)) {
                adjMap.put(from, new ArrayList<>());
            }
            if (!adjMap.containsKey(to)) {
                adjMap.put(to, new ArrayList<>());
            }
            adjMap.get(from).add(new Pair<>(to, dist));
            adjMap.get(to).add(new Pair<>(from, dist));
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int ans = Integer.MAX_VALUE;
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int first = queue.poll();
                visited.add(first);
                if (!adjMap.containsKey(first)) continue;
                List<Pair<Integer, Integer>> neighbors = adjMap.get(first);
                for (Pair<Integer, Integer> neighbor : neighbors) {
                    int neighborID = neighbor.getKey();
                    int dist = neighbor.getValue();
                    if (!visited.contains(neighborID)) {
                        queue.offer(neighborID);
                    }
                    ans = Math.min(ans, dist);
                }
            }
        }
        return ans;

    }
}

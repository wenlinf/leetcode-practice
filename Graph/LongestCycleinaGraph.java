class Solution {
    public int longestCycle(int[] edges) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        int n = edges.length;
        for (int i = 0; i < n; i++) {
            int from = i;
            int to = edges[i];
            if (!adjMap.containsKey(from)) {
                adjMap.put(from, new ArrayList<>());
            }
            adjMap.get(from).add(to);
        } 
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                Map<Integer, Integer> seen = new HashMap<>();
                int currLen = 0;
                dfs(i, adjMap, seen, currLen, visited);
            }
        }
        return longestCycle;
    }
    private int longestCycle = -1;
    private void dfs(int start, Map<Integer, List<Integer>> adjMap, Map<Integer, Integer> seen, int currLen, Set<Integer> visited) {
        if (!adjMap.containsKey(start)) return;
        if (seen.containsKey(start)) {
            int index = seen.get(start);
            longestCycle = Math.max(currLen - index, longestCycle);
            for (Map.Entry<Integer, Integer> entry : seen.entrySet()) {
                visited. add(entry.getKey());
            }
            return;
        }
        seen.put(start, currLen);
        List<Integer> neighbors = adjMap.get(start);
        for (int neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, adjMap, seen, currLen + 1, visited);
            }
        }
    }
}

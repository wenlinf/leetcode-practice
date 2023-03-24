class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            if (!adjMap.containsKey(from)) {
                adjMap.put(from, new ArrayList<>());
            }
            if (!adjMap.containsKey(to)) {
                adjMap.put(to, new ArrayList<>());
            }
            adjMap.get(from).add(new int[]{to, 1});
            adjMap.get(to).add(new int[]{from, 0});
        }
        dfs(0, -1, adjMap);
        return count;
    }

    private int count;
    private void dfs(int child, int parent, Map<Integer, List<int[]>> adjMap) {
        if (!adjMap.containsKey(child)) return;
        List<int[]> neighbors = adjMap.get(child);
        for (int[] neighbor : neighbors) {
            if (neighbor[0] == parent) continue;
            count += neighbor[1];
            dfs(neighbor[0], child, adjMap);
        }
    }
}

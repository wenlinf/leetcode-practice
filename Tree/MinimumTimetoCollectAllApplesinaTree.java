class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int m = edges.length;
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            if (!adjMap.containsKey(from)) {
                adjMap.put(from, new ArrayList<>());
            }
            if (!adjMap.containsKey(to)) {
                adjMap.put(to, new ArrayList<>());
            }
            adjMap.get(from).add(to);
            adjMap.get(to).add(from);
        }
        return dfs(0, -1, hasApple, adjMap);
    }

    private int dfs(int child, int parent, List<Boolean> hasApple, Map<Integer, List<Integer>> adjMap) {
        if (!adjMap.containsKey(child)) {
            return 0;
        }
        int totalTime = 0;
        int childTime = 0;
        List<Integer> children = adjMap.get(child);
        int n = children.size();
        for (int i = 0; i < n; i++) {
            int node = children.get(i);
            if (node == parent) continue;
            childTime = dfs(node, child, hasApple, adjMap);
            if (childTime > 0 || hasApple.get(node)) {
                totalTime += childTime + 2;
            }
        }
        return totalTime;
    }
}

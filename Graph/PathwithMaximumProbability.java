class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] out = new int[n];
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> in = new HashMap<>();
        for (int i = 0; i < n; i++) {
            out[i] = graph[i].length;
            for (int vertex : graph[i]) {
                if (!in.containsKey(vertex)) {
                    in.put(vertex, new ArrayList<>());
                }
                in.get(vertex).add(i);
            }
            
            if (out[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int safe = queue.poll();
            result.add(safe);
            if (in.containsKey(safe)) {
                List<Integer> fromNodes = in.get(safe);
                for (int from : fromNodes) {
                    out[from]--;
                    if (out[from] == 0) queue.add(from);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}

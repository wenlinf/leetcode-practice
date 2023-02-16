class Solution {
    int RED = 0;
    int BLUE = 1;
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        for (int [] edge : redEdges) {
            int from = edge[0];
            int to = edge[1];
            if (!adjMap.containsKey(from)) {
                adjMap.put(from, new ArrayList<>());
            }
            adjMap.get(from).add(new int[]{to, RED});
        }
        for (int[] edge : blueEdges) {
            int from = edge[0];
            int to = edge[1];
            if (!adjMap.containsKey(from)) {
                adjMap.put(from, new ArrayList<>());
            }
            adjMap.get(from).add(new int[]{to, BLUE});
        }
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, -1}); // id, step, prevColor
        boolean[][] visited = new boolean[n][2];
        int[] result = new int[n];
        Arrays.fill(result, -1);
        result[0] = 0;
        visited[0][1] = true;
        visited[0][0] = true;
        while (queue.size() != 0) {
            int[] first = queue.pop();
            int id = first[0];
            int step = first[1];
            int prevColor = first[2];
            if (!adjMap.containsKey(id)) {
                continue;
            }
            List<int[]> neighbors = adjMap.get(id);
            for (int[] neighbor : neighbors) {
                int neighborID = neighbor[0];
                int neighborColor = neighbor[1];
                if (visited[neighborID][neighborColor]) continue;
                if (neighborColor != prevColor) {
                    if (result[neighborID] == -1) {
                        result[neighborID] = step + 1;
                    }
                    queue.add(new int[]{neighborID, step + 1, neighborColor});
                    visited[neighborID][neighborColor] = true;
                }
            }
        }
        return result;
        
    }
}

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        // find the minimum distance from node1, node2 to every other node
        // when they have a common destination, get the maximum
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[node1] = 0;
        dist2[node2] = 0;
        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];
        dfs(node1, edges, visited1, dist1);
        dfs(node2, edges, visited2, dist2);
        int answer = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int max = Math.max(dist1[i], dist2[i]);
            if (max < min) {
                answer = i;
                min = max;
            }
        }
        return answer;
    }

    private void dfs(int start, int[] edges, boolean[] visited, int[] dist) {
        int next = edges[start];
        visited[start] = true;
        if (next != -1 && !visited[next]) {
            dist[next] = 1 + dist[start];
            dfs(next, edges, visited, dist);
        }
    }
}

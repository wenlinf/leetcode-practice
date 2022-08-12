class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<double[]>> adjList = new HashMap<>();
        Map<Integer, Double> curr = new HashMap<>();
        int m = edges.length;
        // create adjacency list
        for (int i = 0; i < m; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double prob = succProb[i];
            if (!adjList.containsKey(from)) {
                adjList.put(from, new ArrayList<>());
            }
            if (!adjList.containsKey(to)) {
                adjList.put(to, new ArrayList<>());
            }
            adjList.get(from).add(new double[]{to, prob});
            adjList.get(to).add(new double[]{from, prob});
        }
        for (int i = 0; i < n; i++) {
            curr.put(i, 0.0);
        }
        
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->Double.compare(b[1], a[1])); 
        pq.add(new double[]{start, 1.0}); 
        
        
        while (!pq.isEmpty()) {
            double[] next = pq.poll();
            int index = (int)next[0];
            if (index == end) break;
            if (!adjList.containsKey(index)) continue; 
            double nextDist = next[1];
            if (nextDist < curr.get(index)) continue;
            List<double[]> neighbors = adjList.get(index);
            for (double[] neighbor : neighbors) {
                int neighborIndex = (int)neighbor[0];
                double neighborProb = neighbor[1];
                if(nextDist * neighborProb > curr.get(neighborIndex)) {
                    curr.put(neighborIndex, nextDist * neighborProb);
                    pq.offer(new double[]{neighborIndex, nextDist * neighborProb});
                }
            }
        }
        return curr.get(end);
    }
}

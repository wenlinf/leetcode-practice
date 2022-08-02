class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1 || n == 2) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            return list;
        }
        
        List<Set<Integer>> adjList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
        }
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (adjList.get(i).size() == 1) {
                queue.add(i);
            }
        }
        int remainingNodes = n;
        while (remainingNodes > 2) {
            LinkedList<Integer> newqueue = new LinkedList<>();
            while(!queue.isEmpty()) {
                int leaf = queue.poll();
                Set<Integer> neighbours = adjList.get(leaf);
                remainingNodes--;
                for (int neighbour : neighbours) {
                    adjList.get(neighbour).remove(leaf);
                    if (adjList.get(neighbour).size() == 1) {
                        newqueue.add(neighbour);
                    }
                }
                
            }
            queue = newqueue;
        }
        return queue;
    }
}

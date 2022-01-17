class NumberofConnectedComponentsinanUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i; 
        }
        
        for (int i = 0; i < edges.length; i++) {
            union(edges[i][0], edges[i][1], root);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < root.length; i++) {
            if (root[root[i]] != root[i]) {
                root[i] = find(root[root[i]], root);
            }
            set.add(root[i]);
        }
        return set.size();
    }
    
    public int find(int x, int[] root) {
        while (root[x] != x) {
            x = root[x];
        }
        return x;
    }
    
    public void union(int x, int y, int[] root) {
        int rootX = find(x, root);
        int rootY = find(y, root);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }
}

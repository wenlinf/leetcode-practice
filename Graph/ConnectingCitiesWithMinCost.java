class Solution {
    public int minimumCost(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            int cost = connection[2];
            pq.add(new int[]{cost, from, to});
        }
        int minCost = 0;
        while (!pq.isEmpty()) {
            int[] min = pq.poll();
            int from = min[1];
            int to = min[2];
            int cost = min[0];
            if (!uf.connected(from, to)) {
                uf.union(from, to);
                minCost += cost;
            }
        }
        if (uf.getComponents() > 2) return -1;
        return minCost;
    }
}

class UnionFind {
    private int[] root;
    private int[] rank;
    private int components;
    
    public UnionFind(int size) {
        this.root = new int[size];
        this.rank = new int[size];
        this.components = size;
        for (int i = 0; i < size; i++) {
            this.root[i] = i;
            this.rank[i] = 0;
        }
    }
    
    public int find(int x) {
        if (x == root[x]) return x;
        return root[x] = find(root[x]);
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            rank[rootX]++;
        }
        this.components--;
    }
    
    public int getComponents() {
        return this.components;
    }
    
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

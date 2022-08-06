class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        UnionFind uf = new UnionFind(n + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int[] pipe : pipes) {
            pq.add(pipe);
        }
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{0, i + 1, wells[i]});
        }
        int minCost = 0;
        while (!pq.isEmpty()) {
            int[] minimum = pq.poll();
            int from = minimum[0];
            int to = minimum[1];
            int cost = minimum[2];
            if (!uf.connected(from, to)) {
                uf.union(from, to);
                minCost += cost;
            }
        }
        return minCost;
    }
}

class UnionFind {
    private int[] root;
    private int[] rank;
    
    public UnionFind(int size) {
        this.root = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }
    
        
    int find(int x) {
        if (x == root[x]) return x;
        root[x] = find(root[x]);
        return root[x];
        // return root[x] = find(root[x]);
    }
    
    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            root[rootX] = rootY;
        } else {
            root[rootX] = rootY;
            rank[rootY]++;
        }
    }
    
    boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

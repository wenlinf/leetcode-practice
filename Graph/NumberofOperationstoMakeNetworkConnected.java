class Solution {
    public int makeConnected(int n, int[][] connections) {
        int redundantEdges = 0;
        UnionFind uf = new UnionFind(n);
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            if (uf.connected(from, to)) {
                redundantEdges++;
            } else {
                uf.union(from, to);
            }
        }
        int components = uf.getComponents();
        if (redundantEdges < components - 1) return -1;
        return components - 1;
    }
}

class UnionFind {
    private int[] rank;
    private int[] root;
    private int components;

    public UnionFind(int size) {
        this.rank = new int[size];
        this.root = new int[size];
        for (int i = 0; i < size; i++) {
            rank[i] = 1;
            root[i] = i;
        }
        this.components = size;
    }

    public int find(int x) {
        if (x == root[x]) return x;
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        if (!connected(x, y)) {
            int rootX = find(x);
            int rootY = find(y);
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else {
                root[rootX] = rootY;
            }
            this.components--;
        } 
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public int getComponents() {
        return this.components;
    }
}

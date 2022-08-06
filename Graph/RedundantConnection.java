class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (uf.connected(from, to)) return edge;
            uf.union(from, to);
        }
        return new int[2];
    }
}

class UnionFind {
    private int[] root;
    private int[] rank;
    
    UnionFind(int size) {
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

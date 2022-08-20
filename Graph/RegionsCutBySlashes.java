class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n * n * 4);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char cell = grid[i].charAt(j);
                int root = (i * n + j) * 4;
                if (cell != '/') {
                    uf.union(root + 0, root + 2);
                    uf.union(root + 1, root + 3);
                }
                if (cell != '\\') {
                    uf.union(root + 1, root + 0);
                    uf.union(root + 2, root + 3);
                }
                if (j < n - 1) {
                    uf.union(root + 2, root + 4 + 1);
                }
                if (j >= 1) {
                    uf.union(root + 1, root - 4 + 2);
                }
                if (i < n - 1) {
                    uf.union(root + 3, root + 4 * n + 0);
                }
                if (i >= 1) {
                    uf.union(root + 0, root - 4 * n + 3);
                }
            }
        }
        return uf.getComponents();
    }
}

class UnionFind {
        private int[] root;
        private int[] rank;
        private int size;
    private int components;
        
        public UnionFind(int size) {
            this.root = new int[size];
            this.rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
            this.components = size;
        }
        
        public int find(int x) {
            if (root[x] == x) return x;
            return root[x] = find(root[x]);
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else if(rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else {
                    root[rootX] = rootY;
                    rank[rootY]++;
                }
            }
            components--;
        }
        
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    
    public int getComponents() {
        return this.components;
    }

    }

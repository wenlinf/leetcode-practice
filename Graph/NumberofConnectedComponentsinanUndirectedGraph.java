class Solution {
    public int countComponents(int n, int[][] edges) {
        // same as number of provinces
        // no repeated edges
        if (n == 1) return 1;
        // create unionFInd instance
        UnionFind unionFind = new UnionFind(n);
        // traverse the edges array
        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            // connect the two vertices in each sub array
            unionFind.union(first, second);
        }
        // return the count
        return unionFind.getCount();
    }
    
    public class UnionFind {
        private int[] root;
        private int[] rank;
        private int count;
        
        public UnionFind(int size) {
            this.root = new int[size];
            this.rank = new int[size];
            this.count = size;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if (this.root[x] == x) return x;
            return this.root[x] = find(root[x]);
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
                this.count--;
            }
        }
        
        public int getCount() {
            return this.count;
        }  
    }
}

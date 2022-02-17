class Solution {
    public int findCircleNum(int[][] isConnected) {
        // if n == 1, return 1
        if (isConnected.length == 1) {
            return 1;
        }
        // create unionfind instance 
        UnionFind unionFind = new UnionFind(isConnected.length);
        // traverse the matrix and connect nodes where matrix[i][j] == 1
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        // traverse the root array, and count the number of distinct roots in the array
        Set<Integer> provinces = new HashSet<>();
        for (int i = 0; i < unionFind.root.length; i++) {
            if (i == unionFind.root[i]) {
                provinces.add(unionFind.root[i]);
            } else {
                provinces.add(unionFind.find(i));
            }
        }
        // return the count
        return provinces.size();
    }
    
    
    public class UnionFind {
        public int[] root;
        public int[] rank;
        private int size;
        
        public UnionFind(int size) {
            this.root = new int[size];
            this.rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int node) {
            if (this.root[node] == node) return node;
            return root[node] = find(root[node]); // ??
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
        
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}

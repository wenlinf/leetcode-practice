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
            for (int j = i; j < isConnected[0].length; j++) {
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
        // can add a count field here
        // private int count;
        
        public UnionFind(int size) {
            this.root = new int[size];
            this.rank = new int[size];
            // this.count = size;
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
            //this.count--;
        }
        
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
        /*
        public int getCount() {
            return this.count;
        }
        */
    }
}


//DFS solution
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (j != i && isConnected[i][j] == 1) {
                    list.add(j);
                }
            }
            adjList.put(i, list);
        }
        Set<Integer> seen = new HashSet<>();
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!seen.contains(i)) {
                provinces++;
                dfs(i, adjList, seen);
            }
        }
        return provinces;
    }
    
    private void dfs(int start, Map<Integer, List<Integer>> adjList, Set<Integer> seen) {
        seen.add(start);
        if (adjList.containsKey(start)) {
            List<Integer> neighbors = adjList.get(start);
            for (int neighbor : neighbors) {
                if (!seen.contains(neighbor)) {
                    dfs(neighbor, adjList, seen);
                }
            }
        }
    }
}

// DFS no need to build an adj list
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                provinces++;
                dfs(isConnected, visited, i);
            }
        }
        return provinces;
    }
    
    private void dfs(int[][] isConnected, int[] visited, int i) {
        int m = isConnected[i].length;
        visited[i] = 1;
        for (int j = 0; j < m; j++) {
            if (i == j) continue;
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                dfs(isConnected, visited, j);
            }
        }
    }
}

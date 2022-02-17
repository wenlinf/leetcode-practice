class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        List<Integer>[] adjList = new ArrayList[n];
        int[] visited = new int[n];
        int components = 0;
        
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        dfs(adjList, visited, 0);
        
        
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) return false;
        }
        return true;
        
        /*
        // My first solution was to check the number of components
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                components++;
                dfs(adjList, visited, i);
            }
        }
        
        return components == 1;
        */
    }
    
    public void dfs(List<Integer>[] adjList, int[] visited, int startNode) {
        visited[startNode] = 1;
        
        for (int i = 0; i < adjList[startNode].size(); i++) {
            if (visited[adjList[startNode].get(i)] == 0) {
                dfs(adjList, visited, adjList[startNode].get(i));
            }
        }
    }
}



class Solution {
    public boolean validTree(int n, int[][] edges) {
        // there are no repeated edges, no self loops
        // if n == 1 it is a valid tree
        if (n == 1) return true;
        // create a unionFind instance
        UnionFind unionFind = new UnionFind(n);
        // traverse the edges array and union the vertices
        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            // if two nodes are already connected, return false
            if (unionFind.connected(first, second)) {
                return false;
            }
            unionFind.union(first, second);
        }
        // if the number of edges (number of union operations) is not n-1, return false
        return unionFind.getEdges() == n - 1;
        // else return true
    }
    
    public class UnionFind {
        private int[] root;
        private int[] rank;
        private int size;
        private int edges;
        
        public UnionFind(int size) {
            this.root = new int[size];
            this.rank = new int[size];
            this.edges = 0;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if (root[x] == x) return x;
            return root[x] = find(root[x]);
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else if(rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else {
                    root[rootX] = rootY;
                    rank[rootY]++;
                }
                edges++;
            }
        }
        
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
        
        public int getEdges() {
            return this.edges;
        }
    }
}

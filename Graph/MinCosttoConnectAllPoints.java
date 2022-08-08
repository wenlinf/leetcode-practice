class MinCosttoConnectAllPoints {
    class Edge {
        int point1;
        int point2;
        int weight;
        public Edge(int point1, int point2, int weight) {
            this.point1 = point1;
            this.point2 = point2;
            this.weight = weight;
        }
    }
    
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);

        for (int i = 0; i < points.length - 1; i++) {
            int[] point1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] point2 = points[j];
                int cost = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
                Edge edge = new Edge(i, j, cost);
                pq.add(edge);
            }
        }
        
        int[] root = new int[points.length];
        int[] rank = new int[points.length];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
            rank[i] = 1;
        }
        
        int count = 0;
        int result = 0;
        while (!pq.isEmpty() && count < points.length - 1) {
            Edge edge = pq.poll();
            if (!connected(edge.point1, edge.point2, root)) {
                union(edge.point1, edge.point2, root, rank);
                result += edge.weight;
                count++;
            }
        }
        
        
        return result;
    }
    
    public int find(int x, int[] root) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x], root);
    }
    
    public void union(int x, int y, int[] root, int[] rank) {
        int rootX = find(x, root);
        int rootY = find(y, root);
        if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
        }
    }
    
    public boolean connected(int x, int y, int[] root) {
        int rootX = find(x, root);
        int rootY = find(y, root);
        return rootX == rootY;
    }
}


//Prim
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            int distance = Math.abs(points[0][0] - points[i][0]) + Math.abs(points[0][1] - points[i][1]);
            pq.add(new int[]{distance, 0, i});
        }
        int minCost = 0;
        while (visited.size() != n) {
            int[] smallest = pq.poll();
            int curr = smallest[2];
            if (visited.contains(curr)) continue;
            minCost += smallest[0];
            visited.add(curr);
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i)) {
                    int distance = Math.abs(points[curr][0] - points[i][0]) + Math.abs(points[curr][1] - points[i][1]);
                    pq.add(new int[]{distance, curr, i});
                }
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
    }
    
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

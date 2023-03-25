class Solution {
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (!uf.connected(from, to)) {
                uf.union(from, to);
            }
        }
        List<Integer> sizes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            if (root == i) {
                sizes.add(uf.getSize(root));
            }
        }
        long res = 0;
        long remain = n;
        for (int i = 0; i < sizes.size(); i++) {
            res += sizes.get(i) * (remain - sizes.get(i));
            remain -= sizes.get(i);
        }
        return res;
    }
}

class UnionFind {
    private int[] root;
    private int[] rank;
    private int[] size;

    public UnionFind(int num) {
        this.root = new int[num];
        this.rank = new int[num];
        this.size = new int[num];
        for (int i = 0; i < num; i++) {
            root[i] = i;
            rank[i] = 1;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (x == root[x]) return x;
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        if (connected(x, y)) return;
        int rootX = find(x);
        int rootY = find(y);
        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
            size[rootX] += size[rootY];
        } else {
            root[rootX] = rootY;
            size[rootY] += size[rootX];
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public int getSize(int x) {
        return size[find(x)];
    }
}

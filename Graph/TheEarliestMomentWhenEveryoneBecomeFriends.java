class Solution {
    public int earliestAcq(int[][] logs, int n) {
        // timestamp is not sorted 
        //symmetric -- undirected
        // x y pair only occurs once
        // if there's only one log, return the timestamp
        if (logs.length == 1) {
            return logs[0][0];
        }
        // sort the logs by timestamp
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] log1, int[] log2) {
                int timeStamp1 = log1[0];
                int timeStamp2 = log2[0];
                return timeStamp1 - timeStamp2;
            }
        });
        // can use lambda
        // Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        
        // create a union find instance
        UnionFind unionFind = new UnionFind(n);
        // traverse the logs array
        for (int i = 0; i < logs.length; i++) {
            int timestamp = logs[i][0];
            int first = logs[i][1];
            int second = logs[i][2];
            unionFind.union(first, second);
            if (unionFind.getCount() == 1) {
                return timestamp;
            }
        }
        // union the pair
        // when the count becomes one, return the timestamp
        // return -1 at the end if nothing was returned earlier
        return -1;
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
                this.root[i] = i;
                this.rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if (x == this.root[x]) return x;
            return root[x] = find(root[x]);
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootX] = rootY;
                    rank[rootY]++;
                }
                this.count--;
            }
        }
        
        public int getCount() {
            return this.count;
        }
    }
}

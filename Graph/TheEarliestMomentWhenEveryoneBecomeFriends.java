class TheEarliestMomentWhenEveryoneBecomeFriends {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        
        int[] root = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 0;
        }
        
        int components = n;
        for (int i = 0; i < logs.length; i++) {
            boolean isMerged = union(logs[i][1], logs[i][2], root, rank);
            if (isMerged) components--;
            if (components == 1) return logs[i][0];
        }
        
        return -1;
    }
    
//     public int find(int x, int[] root) {
//         int rootNode = x;
//         while (rootNode != root[rootNode]) {
//             rootNode = root[rootNode];
//         }
//         while (x != rootNode) {
//             int oldRoot = root[x];
//             root[x] = rootNode;
//             x = oldRoot;
//         }
//         return rootNode;
//     }
    
    public int find(int person, int[] group) {
        if (group[person] != person)
            group[person] = find(group[person], group);
        return group[person];
    }
    
    // public int union(int x, int y, int[] root) {
    //     int rootX = find(x, root);
    //     int rootY = find(y, root);
    //     if (rootX != rootY) {
    //         root[rootX] = rootY;
    //     }
    //     return rootY;
    // }
    
        public boolean union(int a, int b, int[] group, int[] rank) {
            int groupA = find(a, group);
            int groupB = find(b, group);
            boolean isMerged = false;

            if (groupA == groupB) return isMerged;
            
            isMerged = true;
            // Merge the lower-rank group into the higher-rank group.
            if (rank[groupA] > rank[groupB]) {
                group[groupB] = groupA;
            } else if (rank[groupA] < rank[groupB]) {
                group[groupA] = groupB;
            } else {
                group[groupA] = groupB;
                rank[groupB] += 1;
            }

            return isMerged;
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int numOfNodes = isConnected.length;
        int[] root = new int[numOfNodes];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
        
        for (int i = 0; i < numOfNodes; i++) {
            for (int j = i + 1; j < numOfNodes; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    union(root[j], root[i], root);
                } 
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < root.length; i++) {
            int rootNode = find(i, root);
            set.add(rootNode);
        }
        return set.size();
    }
    
    public int find(int num, int[] root) {
        while (root[num] != num) {
            num = root[num];
        }
        return num;
    }
    
    public void union(int x, int y, int[] root) {
        int rootX = find(x, root);
        int rootY = find(y, root);
        if (rootX != rootY) {
            root[rootX] = rootY;
        }
    }
}

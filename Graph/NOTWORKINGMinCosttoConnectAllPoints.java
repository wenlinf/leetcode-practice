class NOTWORKINGMinCosttoConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        Map<List<Integer>, Integer> distances = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                distances.put(list, distance);
            }
        }
        
        List<Map.Entry<List<Integer>, Integer>> list = new ArrayList<>(distances.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<List<Integer>, Integer> sorted = new LinkedHashMap<>();
        for (Map.Entry<List<Integer>, Integer> entry : list) {
            sorted.put(entry.getKey(), entry.getValue());
        }
        
        int result = 0;
        int count = 0;
        int[] root = new int[points.length];
        int[] rank = new int[points.length];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
            rank[i] = 1;
        }
        for (Map.Entry<List<Integer>, Integer> entry: sorted.entrySet()) {
            if (count == points.length - 1) return result;
            List<Integer> indices = entry.getKey();
            if (!connected(indices.get(0), indices.get(1), root)) {
                union(indices.get(0), indices.get(1), root, rank);
                result += entry.getValue();
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

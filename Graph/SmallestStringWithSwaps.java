class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] root = new int[s.length()];
        int[] rank = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            rank[i] = 1;
            root[i] = i;
        }
        for (int i = 0; i < pairs.size(); i++) {
            union(pairs.get(i).get(0), pairs.get(i).get(1), root, rank);
        }  
        
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < root.length; i++) {
            if (root[root[i]] != root[i]) {
                root[i] = find(root[root[i]], root);
            }           
            if (!map.containsKey(root[i])) {
                map.put(root[i], new ArrayList<>());
            }
            map.get(root[i]).add(s.charAt(i));
        }
        for (List<Character> list: map.values()) {
            Collections.sort(list);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            result.append(map.get(root[i]).remove(0));
        }
        
        
        return result.toString();
    }
    
    public int find(int x, int[] root) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }
    
    public void union(int x, int y, int[] root, int[] rank) {
        int rootX = find(x, root);
        int rootY = find(y, root);
        
        if (rootX != rootY) {
            int rankX = rank[x];
            int rankY = rank[y];
            if (rankX >= rankY) {
                root[rootY] = rootX;
            } else {
                root[rootX] = rootY;
            }
        }
    }
}

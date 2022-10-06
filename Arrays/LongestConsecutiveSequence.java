class Solution {
    
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        UnionFind uf = new UnionFind(n, nums);
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) continue;
            int num = nums[i];
            map.put(num, i);
            if (map.containsKey(num - 1) && !uf.connected(map.get(num), map.get(num - 1))) {
                uf.union(i, map.get(num - 1));
            }
            if (map.containsKey(num + 1) && !uf.connected(map.get(num), map.get(num + 1))) {
                uf.union(i, map.get(num + 1));
            }
        }
        return uf.getMax();
    }
    
    
}

class UnionFind {
    private int[] root;
    private int[] nodes;
    
    public UnionFind(int size, int[] nums) {
        root = new int[size];
        nodes = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            nodes[i] = 1;
        }
    }
    
    public int find (int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;
        if (nodes[rootX] > nodes[rootY]) {
            root[rootY] = rootX;
            nodes[rootX] += nodes[rootY];
        } else {
            root[rootX] = rootY;
            nodes[rootY] += nodes[rootX];
        }
    }
    
    public int getMax() {
        int max = 0;
        for (int node : nodes) {
            max = Math.max(max, node);
        }
        return max;
    }
    
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

// HashSet O(n) time solution
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currLen = 1;
                int increase = num + 1;
                while (set.contains(increase)) {
                    currLen++;
                    increase++;
                }
                longest = Math.max(longest, currLen);
            }
        }
        return longest;
    }
}

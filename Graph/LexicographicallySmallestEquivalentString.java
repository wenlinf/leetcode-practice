class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        UnionFind uf = new UnionFind();
        for (int i = 0; i < n; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (!uf.connected(ch1 - 'a', ch2 - 'a')) {
                uf.union(ch1 - 'a', ch2 - 'a');
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char ch = baseStr.charAt(i);
            char newChar = uf.findSmallest(ch - 'a');
            sb.append(newChar);
        }
        return sb.toString();
    }
}

class UnionFind {
    private int[] root;
    private int[] rank;
    private int[] smallest;

    public UnionFind() {
        this.root = new int[26];
        this.rank = new int[26];
        this.smallest = new int[26];
        for (int i = 0; i < 26; i++) {
            root[i] = i;
            rank[i] = 1;
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
        } else if (rank[rootY] > rank[rootX]) {
            root[rootX] = rootY;
        } else {
            root[rootX] = rootY;
            rank[rootY]++;
        }
    }

    public void buildSmallest() {
        for (int i = 0; i < 26; i++) {
            int root = find(i);
            int smallestNum = 27;
            for (int j = 0; j < 26; j++) {
                int root2 = find(j);
                if (root == root2) {
                    smallestNum = Math.min(smallestNum, j);
                }
            }
            smallest[i] = smallestNum;
        }
    }

    public char findSmallest(int x) {
        this.buildSmallest();
        return (char)(smallest[x] + 'a');
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

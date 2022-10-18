// solution from: https://www.youtube.com/watch?v=zqe_zIkyVGQ
// Top down DP
class Solution {
    private List<List<Integer>> graph;
    public int longestStrChain(String[] words) {
        int n = words.length;
        if (n == 1) return 1;
        this.memo = new int[n];
        Map<String, Integer> map = new HashMap<>();
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                String sub = word.substring(0, j) + word.substring(j + 1, word.length());
                if (!map.containsKey(sub)) continue;
                graph.get(i).add(map.get(sub));
            }
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, longest(i));
        }
        return ans;
    }
    private int[] memo;
    private int longest(int index) {
        if (memo[index] != 0) return memo[index];
        List<Integer> neighbors = graph.get(index);
        int length = 1;
        for (int i = 0; i < neighbors.size(); i++) {
            length = Math.max(length, longest(neighbors.get(i)) + 1);
        }
        memo[index] = length;
        return length;
    }
}

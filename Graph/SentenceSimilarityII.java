class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> pair : similarPairs) {
            String from = pair.get(0);
            String to = pair.get(1);
            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            if (!map.containsKey(to)) {
                map.put(to, new ArrayList<>());
            }
            map.get(from).add(to);
            map.get(to).add(from);
        }
        int n = sentence1.length;
        for (int i = 0; i < n; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];
            if (word1.equals(word2)) continue;
            if (!map.containsKey(word1) || !map.containsKey(word2)) return false;
            Set<String> visited = new HashSet<>();
            boolean similar = dfs(word1, word2, map, visited);
            if (!similar) return false;
        }
        return true;
    }

    private boolean dfs(String word1, String word2, Map<String, List<String>> map, Set<String> visited) {
        if (visited.contains(word1)) return false;
        visited.add(word1);
        if (!map.containsKey(word1)) return false;
        List<String> neighbors = map.get(word1);
        for (String neighbor : neighbors) {
            if (neighbor.equals(word2)) return true;
            if (dfs(neighbor, word2, map, visited)) return true;
        }
        return false;
    }
}

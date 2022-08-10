class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        
        LinkedList<String> queue = new LinkedList<>();
        
        int m = beginWord.length();
        
        Map<String, List<String>> dict = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < m; i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1, m);
                if (!dict.containsKey(key)) {
                    dict.put(key, new ArrayList<>());
                }
                dict.get(key).add(word);
            }
        }
        queue.add(beginWord);
        
        Set<String> visited = new HashSet<>();
        int moves = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                String first = queue.poll();
                visited.add(first);
                if (first.equals(endWord)) return moves;
                for (int i = 0; i < m; i++) {
                    String replaceChar = first.substring(0, i) + "*" + first.substring(i+1, m);
                    if (!dict.containsKey(replaceChar)) continue;
                    List<String> neighbors = dict.get(replaceChar);
                    for (String neighbor : neighbors) {
                        if (!visited.contains(neighbor)) {
                            queue.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
                levelSize--;
            }
            moves++;
        }
        return 0;
    }
}

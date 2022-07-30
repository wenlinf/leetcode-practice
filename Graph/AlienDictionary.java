class Solution {
    public String alienOrder(String[] words) {
        int n = words.length;
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                inDegree.put(ch, 0);
            }
        }
        for (int i = 1; i < n; i++) {
            String word = words[i];
            String prev = words[i - 1];
            if (word.length()  < prev.length() && prev.startsWith(word)) return "";
            int len = Math.min(word.length(), prev.length());
            for (int j = 0; j < len; j++) {
                char prevChar = prev.charAt(j);
                char wordChar = word.charAt(j);

                if (wordChar != prevChar) {
                    if (!adjList.containsKey(prevChar)) {
                        adjList.put(prevChar, new ArrayList<>());
                    }
                    adjList.get(prevChar).add(wordChar);
                    inDegree.put(wordChar, inDegree.get(wordChar) + 1);
                    break;
                } 
            }
        }
        LinkedList<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        while (!queue.isEmpty()) {
            char start = queue.poll();
            sb.append(start);
            if (adjList.containsKey(start)) {
                List<Character> neighbours = adjList.get(start);
                for (char neighbour : neighbours) {
                    inDegree.put(neighbour, inDegree.get(neighbour) - 1);
                    if (inDegree.get(neighbour) == 0) {
                        queue.add(neighbour);
                    }
                }
            }     
        }
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() != 0) {
                return "";
            }
        }  
        return sb.toString();
    }
}

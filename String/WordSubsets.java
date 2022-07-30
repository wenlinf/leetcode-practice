class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        Map<Character, Integer> need = new HashMap<>();
        for (String word2 : words2) {
            Map<Character, Integer> curr = new HashMap<>();
            for (char ch : word2.toCharArray()) {
                curr.put(ch, curr.getOrDefault(ch, 0) + 1);
                for (Map.Entry<Character, Integer> entry : curr.entrySet()) {
                    char key = entry.getKey();
                    int val = entry.getValue();
                    if (need.containsKey(key)) {
                        if (need.get(key) < val) {
                            need.put(key, val);
                        }
                    } else {
                        need.put(key, val);
                    }
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (String word1 : words1) {
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : word1.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            boolean isUniversal = true;
            for (Map.Entry<Character, Integer> entry : need.entrySet()) {
                char key = entry.getKey();
                int val = entry.getValue();
                if (!map.containsKey(key)) {
                    isUniversal = false;
                    break;
                }
                if (map.get(key) < val) isUniversal = false;
            }
            if (isUniversal) result.add(word1);
        }
        return result;
    }
}


class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxCount = new int[26];
        for (String word2 : words2) {
            int[] count  = getCount(word2);
            for (int i = 0; i < 26; i++) {
                maxCount[i] = Math.max(maxCount[i], count[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (String word1 : words1) {
            boolean isUniversal = true;
            int[] count = getCount(word1);
            for (int i = 0; i < 26; i++) {
                if (count[i] < maxCount[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) result.add(word1);
        }
        return result;
    }
    
    private int[] getCount(String word) {
        int[] ans = new int[26];
        for (char ch : word.toCharArray()) {
            ans[ch - 'a'] ++;
        }
        return ans;
    }
}

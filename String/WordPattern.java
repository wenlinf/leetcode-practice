class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (map.containsKey(word)) {
                int index = map.get(word);
                sb.append(index);
            } else {
                map.put(word, i);
                sb.append(i);
            }
            
        }
        Map<Character, Integer> map2 = new HashMap<>();
        char[] arr = pattern.toCharArray();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (map2.containsKey(ch)) {
                sb2.append(map2.get(ch));
            } else {
                map2.put(ch, i);
                sb2.append(i);
            }
        }
        return sb.toString().equals(sb2.toString());
    }
}

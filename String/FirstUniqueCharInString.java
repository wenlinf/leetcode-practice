class FirstUniqueCharInString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int val = map.get(s.charAt(i));
                map.put(s.charAt(i), ++val);
            }
            else map.put(s.charAt(i), 1);
        }
        char unique = 'A';
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                unique = entry.getKey();
                break;
            }
        }
        if (unique == 'A') return -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == unique) return i;
        }
        return -1;
    }
}

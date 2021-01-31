class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) return false;
            if (map.get(t.charAt(i)) == 0) return false;
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        return true;
    }
}

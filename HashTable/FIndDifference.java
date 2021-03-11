class FIndDifference {
    public char findTheDifference(String s, String t) {
        if (s.length() == 0) return t.charAt(0);
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) map.put(s.charAt(i), 1);
            else map.put(s.charAt(i), map.get(s.charAt(i))+1);
        }
        for (int i =0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) return t.charAt(i);
            else map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) return entry.getKey();
        }
        return ' ';
    }
}

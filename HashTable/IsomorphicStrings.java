class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        char c1 = s.charAt(0);
        char c2 = t.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            c1 = s.charAt(i);
            c2 = t.charAt(i);
            if (mapS.containsKey(c1)) {
                if (!mapT.containsKey(c2)) return false;
                if (mapS.get(c1) != mapT.get(c2)) return false;
            } else {
                if (mapT.containsKey(t.charAt(i))) return false;
                mapS.put(c1, i);
                mapT.put(c2, i);
            }
        }
        return true;
    }
}

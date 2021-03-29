class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int maxLength = 0;
        int count = 0;
        int startIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                count++;
            } else {
                int prevIndex = map.get(s.charAt(i));
                map.put(s.charAt(i), i);
                maxLength = Math.max(maxLength, count);
                startIndex = Math.max(startIndex, prevIndex);
                count = i - startIndex;
            }
        }
        maxLength = Math.max(maxLength, count);
        return maxLength;
    }
}

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


class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int right = 0;
        int left = 0;
        int m = s.length();
        int len = 0;
        boolean shrink = false;
        while (right < m) {
            char r = s.charAt(right);
            right++;
            seen.put(r, seen.getOrDefault(r, 0) + 1);

            while (seen.get(r) > 1) {
                char l = s.charAt(left);
                left++;
                seen.put(l, seen.getOrDefault(l, 0) - 1);
            } 
            if (right - left > len) {
                len = right - left;
            }
            
        }
        return len;
    }
}

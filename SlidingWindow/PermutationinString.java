class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int left = 0;
        int valid = 0;
        int start = 0;
        Map<Character, Integer> window = new HashMap<>();
        for (int right = 0; right < n; right++) {
            char ch = s2.charAt(right);
            
            if (map.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(map.get(ch))) {
                    valid++;
                }
            } 
            while (valid == map.size() && right - left + 1 >= m) {
                if (right - left + 1 == m) return true;
                char leftChar = s2.charAt(left);
                left++;
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == window.get(leftChar)) valid--;
                    window.put(leftChar, window.get(leftChar) - 1); 
                }
            }
        }
        return false;
    }
}


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int m = s2.length();
        int left = 0;
        int right = 0;
        int len = m + 1;
        int valid = 0;
        int requiredSize = need.size();
        while (right < m) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            
            while (valid == requiredSize) {
                if (right - left < len) {
                    len = right - left;
                }
                char l = s2.charAt(left);
                if (need.containsKey(l)) {
                    if (need.get(l).equals(window.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
                left++;
            }
        }
        return len == n && len != m + 1 ? true : false;
    }
}

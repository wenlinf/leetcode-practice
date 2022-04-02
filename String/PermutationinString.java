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

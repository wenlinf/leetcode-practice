class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> has = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        
        int m = s.length();
        int n = t.length();
        
        int valid = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        
        for (int i = 0; i < n; i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        for (int right = 0; right < m; right++) {
            char ch = s.charAt(right);
            if (need.containsKey(ch)) {
                has.put(ch, has.getOrDefault(ch, 0) + 1);
                if (has.get(ch).equals(need.get(ch))) valid++;
            }
            
            while (valid == need.size()) {
                if (right - left + 1 < len) {
                    start = left;
                    len = right - left + 1;
                }
                char leftChar = s.charAt(left);
                if (need.containsKey(leftChar)) {
                    if (has.get(leftChar).equals(need.get(leftChar))) valid--;
                    has.put(leftChar, has.get(leftChar) - 1);          
                } 
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}

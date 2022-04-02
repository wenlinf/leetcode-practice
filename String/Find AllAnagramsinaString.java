class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>(); 
        Map<Character, Integer> window = new HashMap<>();
        int m = s.length();
        int n = p.length();
        for (int i = 0; i < n; i++) {
            char r = p.charAt(i);
            need.put(r, need.getOrDefault(r, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int requiredSize = need.size();
        List<Integer> result = new ArrayList<>();
        while (right < m) {
            char r = s.charAt(right);
            right++;
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    valid++;
                }
            }
            while (valid == requiredSize) {
                if (right - left == n) {
                    result.add(left);
                }
                char l = s.charAt(left);
                if (need.containsKey(l)) {
                    if (need.get(l).equals(window.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
                left++;
            }
        }
        return result;
    }
}

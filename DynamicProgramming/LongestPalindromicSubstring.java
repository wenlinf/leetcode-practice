class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String left = helper(s, i, i);
            String right = helper(s, i, i + 1);
            res = res.length() < left.length() ? left : res;
            res = res.length() < right.length() ? right : res;
        }
        return res;
    }
    
    private String helper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}

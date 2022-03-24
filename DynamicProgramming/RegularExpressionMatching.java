class Solution {
    private String s;
    private String p;
    
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;

        return dp(0, 0);
    }
    
    private boolean dp(int i, int j) {
        if (j == p.length()) return i == s.length();
        if (i == s.length()) {
            if ((p.length() - j) % 2 == 1) return false;
            for (; j < p.length(); j+=2) {
                if (p.charAt(j+1) != '*') return false;
            }
            return true;
        }
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    return dp(i + 1, j) || dp(i, j + 2);
                } else {
                    return dp(i+1, j+1);
                }
            } else {
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    return dp(i, j + 2);
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}

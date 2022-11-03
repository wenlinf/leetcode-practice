class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) return true;
        for (int i = 0; i < s.length(); i++) {
            String concat = s.substring(i + 1, s.length()) + s.substring(0, i + 1);
            if (concat.equals(goal)) return true;
        }
        return false;
    }
}

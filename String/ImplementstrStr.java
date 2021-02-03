class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int index = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == (needle.charAt(0))) {
                if (i + needle.length() > haystack.length()) break;
                if (haystack.substring(i, i + needle.length()).equals(needle)) return i;
            }
        }
        return index;
    }
}

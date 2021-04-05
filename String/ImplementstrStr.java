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
    
    
    
    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (needle.length() == 1) return i;
                for (int j = 1; j < needle.length(); j++) {
                    if (i + j >= haystack.length()) return -1;
                    if (haystack.charAt(i+j) != needle.charAt(j)) {
                        break;
                    } 
                    if (j == needle.length() - 1) return i;
                }
            }
        }
        return -1;
    }

}

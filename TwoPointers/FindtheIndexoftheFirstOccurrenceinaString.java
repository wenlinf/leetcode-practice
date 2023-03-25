class Solution {
    public int strStr(String haystack, String needle) {
        int left = 0; 
        int right = 0;
        int n = haystack.length();
        int m = needle.length();
        int iter = 0;
        while (right < n) {
            if (haystack.charAt(right) == needle.charAt(iter)) {
                right++;
                iter++;
            } else {
                left++;
                right = left;
                iter = 0;
            }
            if (iter == m) return left;

        }
        return -1;
    }
}

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int pt1 = 0;
        int pt2 = 0;
        StringBuilder sb = new StringBuilder();
        while (pt1 < m && pt2 < n) {
            sb.append(word1.charAt(pt1));
            pt1++;
            sb.append(word2.charAt(pt2));
            pt2++;
        }
        if (pt1 != m) {
            sb.append(word1.substring(pt1));
        }
        if (pt2 != n) {
            sb.append(word2.substring(pt2));
        }
        return sb.toString();
    }
}

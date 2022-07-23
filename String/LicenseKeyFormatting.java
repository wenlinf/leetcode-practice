class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        String[] strs = s.split("-");
        s = String.join("", strs);
        int n = s.length();
        int first = n % k;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if ((i == first && i != 0) || (i > first && (i - first) % k == 0 )) {
                sb.append("-");
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

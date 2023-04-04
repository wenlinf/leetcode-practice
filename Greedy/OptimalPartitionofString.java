class Solution {
    public int partitionString(String s) {
        int count = 0;
        int n = s.length();
        if (n == 1) return 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (sb.indexOf(String.valueOf(ch)) != -1) {
                count++;
                sb.setLength(0);
            }
            sb.append(ch);
        }
        count++;
        return count;
    }
}

class Solution {
    private static final int m = 1000000007;
    public int numWays(String s) {
        int n = s.length();
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') ones++;
        }
        if (ones == 0) {
            return (int)((n - 2L) * (n - 1L) / 2 % m);
        }
        if (ones % 3 != 0) return 0;
        int split = ones / 3;
        ones = 0;
        int result = 0;
        long first = 0;
        for (int i = 0; i <= n - 3; i++) {
            if (s.charAt(i) == '1') ones++;
            if (ones == split) {
                first++;
            } else if (ones > split) {
                break;
            }
        }
        ones = 0;
        long third = 0;
        for (int j = n - 1; j >= 2; j--) {
            if (s.charAt(j) == '1') ones++;
            if (ones == split) {
                third++;
            } else if (ones > split) {
                break;
            }
        }
        return (int)(first * third % m);
    }
}

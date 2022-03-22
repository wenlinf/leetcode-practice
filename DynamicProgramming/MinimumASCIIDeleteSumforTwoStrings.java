class Solution {
    private String s1;
    private String s2;
    private int[][] dp;
    
    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 999999);
        }
        this.s1 = s1;
        this.s2 = s2;
        return helper(s1.length() - 1, s2.length() - 1);
    }
    
    private int helper(int i, int j) {
        if (i < 0 && j >= 0) {
            int result = 0;
            while (j >= 0) {
                result += s2.charAt(j);
                j--;
            }
            return result;
        }
        if (j < 0 && i >= 0) {
            int result = 0;
            while (i >= 0) {
                result += s1.charAt(i);
                i--;
            }
            return result;
        }
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != 999999) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = helper(i - 1, j - 1);
        } else {
            dp[i][j] = Math.min(helper(i - 1, j) + s1.charAt(i), helper(i, j - 1) + s2.charAt(j));
        }
        return dp[i][j];
    }
    
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(text1, text2, text1.length() - 1, text2.length() - 1, dp);
    }
    
    private int helper(String text1, String text2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = helper(text1, text2, i - 1, j - 1, dp) + 1;
        } else {
            dp[i][j] = Math.max(helper(text1, text2, i - 1, j, dp), helper(text1, text2, i, j- 1, dp)); 
        }
        return dp[i][j];
    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

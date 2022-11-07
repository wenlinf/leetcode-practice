class Solution {
    private String word1;
    private String word2;
    private int[][] dp;
    
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        this.dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int longestCommon = helper(word1.length() - 1, word2.length() - 1);
        return (word1.length() - longestCommon + word2.length() - longestCommon);
    }
    
    public int helper(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = 1 + helper(i - 1, j - 1);
        } else {
            dp[i][j] = Math.max(helper(i - 1, j), helper(i, j - 1));
        }
        return dp[i][j];
    }
}


class Solution {
    public int minDistance(String word1, String word2) {
        // find longest common subsequence
        // then the result would be (word1.length - LCS) + (word2.length - LCS)
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int longestSubsequence = dp[m][n];
        return (m - longestSubsequence) + (n - longestSubsequence);
    }
}

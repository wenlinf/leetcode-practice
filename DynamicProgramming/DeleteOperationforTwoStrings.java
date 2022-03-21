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

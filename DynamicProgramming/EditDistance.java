class Solution {
    private String word1;
    private String word2;
    private int[][] dp;
    
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        dp = new int[word1.length()][word2.length()];
        int m = word1.length();
        int n = word2.length();
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], m + n);
        }
        return helper(m - 1, n - 1);
    }
    
    private int helper(int i, int j) {
        if (j < 0) {
            return i + 1;
        }
        if (i < 0) {
            return j + 1;
        }
        if (dp[i][j] != word1.length() + word2.length()) return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = helper(i - 1, j - 1);
        } else {
            dp[i][j] = Math.min(helper(i, j - 1), Math.min(helper(i - 1, j), helper(i - 1, j - 1))) + 1;
        }
        
        return dp[i][j];
    }
}


class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] table = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            table[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            table[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = 1 + Math.min(table[i][j - 1], Math.min(table[i - 1][j - 1], table[i - 1][j]));
                }
            }
        }
        return table[m][n];
    }
}

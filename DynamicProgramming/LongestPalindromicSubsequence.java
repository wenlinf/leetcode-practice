class Solution {
    public int longestPalindromeSubseq(String s) {
//         int n = s.length();
//         int[][] dp = new int[n - 1][n - 1];
//         for (int i = 0; i < n; i++) {
//             dp[i][i] = 1;
//         }
//         for (int j = 1; j < n; j++) {
//             for (int i = 0; i < j; i++) {
//                 char left = s.charAt(i);
//                 char right = s.charAt(j);
//                 if (left == right) {
                    
//                 }
//             }
//         }
        int n = s.length();
        if (n == 1) return 1;
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(s, 0, n - 1, memo);
        
    }
    
    private int dp(String s, int left, int right, int[][] memo) {
        if (left == right) return 1;
        if (left > right) return 0;
        if (memo[left][right] != -1) return memo[left][right];
        int len = -1;
        if (s.charAt(left) == s.charAt(right)) {
             len =  dp(s, left + 1, right - 1, memo) + 2;
        } else {
             len = Math.max(dp(s, left + 1, right, memo), dp(s, left, right - 1, memo));
        }
        memo[left][right] = len;
        return len;
    }
}


class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}

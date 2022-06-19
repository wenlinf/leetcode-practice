class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) != '1' && s.charAt(i - 2) != '2') {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i - 2];
                }
            }
            else if (s.charAt(i - 2) == '1') {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else if (s.charAt(i - 2) == '2') {
                if (s.charAt(i - 1) != '7' &&
                   s.charAt(i - 1) != '8' &&
                   s.charAt(i - 1) != '9') {
                    dp[i] = dp[i - 2] + dp[i - 1];
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }
}

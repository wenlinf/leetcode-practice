class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        if (n == 1) return wordDict.contains(s);
        
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            boolean result = false;
            for (int j = 0; j <= i; j++) {
                if (dp[j] == true) {
                    if (wordDict.contains(s.substring(j, i))) {
                        result = true;
                    }
                }
            }
            dp[i] = result;
        }
        return dp[n];
    }
}

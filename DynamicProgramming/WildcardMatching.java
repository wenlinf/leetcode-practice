class Solution {
    public boolean isMatch(String s, String p) {
        if (p.equals("*") || p.equals(s)) return true;
        boolean allStar = true;
        for (char ch : p.toCharArray()) {
            if (ch != '*') {
                allStar = false;
                break;
            }
        }
        int m = s.length();
        int n = p.length();
        if (n > 0 && allStar) return true;
        if (s.length() == 0 || p.length() == 0) return false;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        for(int j = 1; j<= n; j++) {
            if(p.charAt(j - 1) == '*'){
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            char schar = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char pchar = p.charAt(j - 1);
                if (pchar == schar) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pchar == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pchar == '*') {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
                } 
            }
        }
        return dp[m][n];
    }
}

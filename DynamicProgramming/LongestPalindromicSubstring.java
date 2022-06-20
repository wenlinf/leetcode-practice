class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String left = helper(s, i, i);
            String right = helper(s, i, i + 1);
            res = res.length() < left.length() ? left : res;
            res = res.length() < right.length() ? right : res;
        }
        return res;
    }
    
    private String helper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}


class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1) return s;
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int end = 0;
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                end = i+1;
            }
        }
        for (int j = 2; j < n; j++) {
            for (int i = 0; i + j < n; i++) {
                int left = i;
                int right = i + j;
                if (left + 1 == right) {
                    dp[left][right] = s.charAt(left) == s.charAt(right);
                } else {
                    if (s.charAt(left) != s.charAt(right)) {
                        dp[left][right] = false;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }
                if (dp[left][right]) {
                    if (j + 1 > maxLen) {
                        maxLen = j + 1;
                        start = left;
                        end = right;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}

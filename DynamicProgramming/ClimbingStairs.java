class ClimbingStairs {
    public int climbStairs(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                arr[i] = 1;
            } else if (i == 1) {
                arr[i] = 2;
            } else {
                arr[i] = arr[i-1] + arr[i-2];
            }
        }
        return arr[n-1];
    }
}


class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;    
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

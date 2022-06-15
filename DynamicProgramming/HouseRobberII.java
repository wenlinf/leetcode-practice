class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] robFirst = new int[nums.length - 1];
        int[] robSecond = new int[nums.length - 1];
        robFirst[0] = nums[0];
        robSecond[0] = nums[1];
        int result;
        for (int i = 1; i < nums.length; i++) {
            if (i >= 1 && i < robFirst.length) {
                if(i == 1) {
                    robFirst[i] = Math.max(nums[i], robFirst[i - 1]);
                } else {
                    robFirst[i] = Math.max((nums[i] + robFirst[i - 2]), robFirst[i - 1]);
                }
            }
            if (i >= 2 && i < nums.length) {
                if (i == 2) {
                    robSecond[i - 1] = Math.max(nums[i], robSecond[i - 2]);
                } else {
                    robSecond[i - 1] = Math.max((nums[i] + robSecond[i - 3]), robSecond[i - 2]);
                }
            }

        }
        result = Math.max(robFirst[robFirst.length - 1], robSecond[robSecond.length - 1]);
        return result;
    }
}

//2020-06-15
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        // rob 0
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int max = dp[n - 2];
        int[] dp2 = new int[n];
        dp2[n - 1] = nums[n - 1];
        dp2[n - 2] = Math.max(nums[n - 1], nums[n - 2]);
        for (int i = n - 3; i > 0; i--) {
            dp2[i] = Math.max(dp2[i + 2] + nums[i], dp2[i + 1]);
        }
        max = Math.max(max, dp2[1]);
        return max;
    }
}

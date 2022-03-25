class Solution {
    // RECURSIVE SOLUTION - TIME LIMITED EXCEEDED !!!!
    private boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        memo = new boolean[n][sum];
        return helper(nums, 0, sum / 2);
    }
    
    private boolean helper(int[] nums, int index, int sum) {
        int n = nums.length;
        if (index >= n && sum != 0) return false;
        if (sum <= 0 && index < n) return false;
        if (index == n && sum == 0) return true;
        if (nums[index] > sum) {
            return helper(nums, index + 1, sum);
        } else {
            return helper(nums, index + 1, sum - nums[index]) || helper(nums, index + 1, sum);
        }
    }
}

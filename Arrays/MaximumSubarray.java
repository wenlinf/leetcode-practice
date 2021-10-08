class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        if (nums.length == 1) return max;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1] >= nums[i] ? nums[i] + nums[i - 1] : nums[i];
            max = Math.max(nums[i], max);
        }
        return max;
    }
}

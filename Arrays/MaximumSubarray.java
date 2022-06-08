class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}

// Prefix sum solution
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        int minPrev = 0;
        int max = nums[0];
        for (int i = 1; i < n + 1; i++) {
            prefix[i] = prefix[i - 1] + nums[i-1];
        }
        for (int i = 0; i < n; i++) {
            minPrev = Math.min(minPrev, prefix[i]);
            max = Math.max(max, prefix[i + 1] - minPrev);
        }
        return max;
    }
}

// Divide and conquer solution
class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    private int helper(int[] nums, int left, int right) {
        if (left > right) return Integer.MIN_VALUE;
        int mid = left + (right - left) / 2;
        int bestRightSum = 0;
        int curr = 0;
        for (int i = mid + 1; i <= right; i++) {
            bestRightSum = Math.max(bestRightSum, curr += nums[i]);
        }
        int bestLeftSum = 0;
        curr = 0;
        for (int i = mid - 1; i >= left; i--) {
            bestLeftSum = Math.max(bestLeftSum, curr += nums[i]);
        }
        int bestMidSum = nums[mid] + bestLeftSum + bestRightSum;
        int bestLeft = helper(nums, left, mid - 1);
        int bestRight = helper(nums, mid + 1, right);
        return Math.max(Math.max(bestLeft, bestRight), bestMidSum);
    }
}

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int suffixSum = nums[n - 1];
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum += nums[i];
            rightMax[i] = Math.max(rightMax[i + 1], suffixSum);
        }
        
        int prefixSum = 0;
        int currMax = 0;
        int maxSum = nums[0]; // need to initialize to nums[0], if set to 0, it can't deal with negative values
        int specialSum = nums[0];

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSum = Math.max(currMax, maxSum);
            if (i + 1 < n) {
              specialSum = Math.max(prefixSum + rightMax[i + 1], specialSum);
            }
            
        }
        return Math.max(specialSum, maxSum);
    }
}

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMin = 0;
        int currMax = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int sum = 0;
        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            currMax = Math.max(nums[i] + currMax, nums[i]);
            maxSum = Math.max(currMax, maxSum);
            currMin = Math.min(currMin + nums[i], nums[i]);
            minSum = Math.min(minSum, currMin);
            sum += nums[i];
        }
        return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
    }
}

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

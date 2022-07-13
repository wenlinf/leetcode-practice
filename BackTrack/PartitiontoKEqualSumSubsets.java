class Solution {
    private int[] subsets;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) return false;
        int target = sum / k;
        
        this.subsets = new int[k];
        return backtrack(nums, k, 0, target);
    }
    
    private boolean backtrack(int[] nums, int k, int index, int target) {
        if (index >= nums.length) return true;
        for (int i = 0; i < k; i++) {
            if (subsets[i] + nums[index] > target || (i > 0 && subsets[i] == subsets[i - 1])) {
                continue;
            }
            subsets[i] += nums[index];
            if (backtrack(nums, k, index + 1, target)) return true;
            subsets[i] -= nums[index];
        }    
        return false;
    }
}

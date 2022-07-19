class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                for (int j = i + 1; j <= Math.min(i + k, nums.length - 1); j++) {
                    if (nums[j] == 1) return false;
                }
                i = i + k;
            }
        }
        return true;
    }
}

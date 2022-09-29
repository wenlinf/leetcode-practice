// Brute force TLE
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) result = Math.max(result, j - i + 1);
            }
        }
        return result;
    }
}

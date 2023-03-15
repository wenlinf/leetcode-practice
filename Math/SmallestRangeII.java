class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = nums[0];
        int max = nums[n - 1];
        int score = max - min;
        for (int i = 0; i < n - 1; i++) {
            int high = Math.max(nums[i] + k, max - k);
            int lo = Math.min(nums[i + 1] - k, min + k);
            score = Math.min(score, high - lo);
        }
        return score;
    }
}

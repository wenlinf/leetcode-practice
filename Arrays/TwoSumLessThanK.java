class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int max = -1;
        while (start < end) {
            if (nums[start] + nums[end] >= k) {
                end--;
            } else {
                max = Math.max(max, nums[start] + nums[end]);
                start++;
            }
        }
        return max;
    }
}

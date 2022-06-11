class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) return n;
        int[] temp = new int[n];
        Arrays.fill(temp, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    temp[i] = Math.max(temp[i], 1 + temp[j]);
                }
            }
        }
        int result = 0;
        for (int i = 0 ; i < n; i++) {
            result = Math.max(result, temp[i]);
        }
        return result;
    }
}

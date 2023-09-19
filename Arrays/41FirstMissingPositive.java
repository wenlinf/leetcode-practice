class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int save = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (num > 0 && num - 1 <= n - 1 && nums[num - 1] != num) {
                int temp = nums[num - 1];
                nums[num - 1] = num;
                nums[i] = temp;
                num = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}

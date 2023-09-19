class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int index;
            if (num < 0) {
                index = -num - 1;
            } else {
                index = num - 1;
            }
            if (nums[index] < 0) {
                for (int i = 0; i < n; i++) {
                    if (nums[i] < 0) {
                        nums[i] = nums[i] * (-1);
                    }
                }
                if (num < 0) {
                    return -num;
                }
                return num;
            } else {
                nums[index] = nums[index] * (-1);
            }
        }
        
        return -1;
    }
}

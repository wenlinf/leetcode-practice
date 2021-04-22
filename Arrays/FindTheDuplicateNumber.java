class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums.length == 2) return nums[0];
        int index = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result = nums[i];
                return Math.abs(result);
            } else {
                nums[index]*= -1;
            }
        }
        return result;
    }
}

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
    public int findDuplicateTwoPointer(int[] nums) {
        if (nums.length == 2) return nums[0];
        int slow = nums[0];
        int fast = nums[0];
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
       
        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                if (i == 0) return 0;
                return i;
            }
            if (nums[i] == target) return i;
        }
        return nums.length;
    }
}

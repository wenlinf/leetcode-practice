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
    
    public int searchInsert2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (int) Math.ceil((start + end) / 2);
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    } 
}

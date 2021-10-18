class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] != target) return -1;
        if (nums.length == 2) {
            if (nums[0] == target) return 0;
            if (nums[1] == target) return 1;
            return -1;
        }
        int lo, hi;
        if (nums[0] > nums[nums.length - 1]) {
            int start = 0;
            int end = nums.length - 1;
            int mid = (start + end) / 2;
            while (start <= end) {
                if ((nums[mid] > nums[start]) && (nums[mid] > nums[end])) {
                    start = mid;
                } else if ((nums[mid] < nums[start]) && (nums[mid] < nums[end])) {
                    end = mid;
                } else {
                    break;
                } 
                mid = (start + end) / 2;
            }
            if (target > nums[mid]) {
               return -1;
            } else if (target < nums[mid]) {
                if (target < nums[0]) {
                    lo = mid + 1;
                    hi = nums.length - 1;
                } else if (target > nums[0]) {
                    lo = 0;
                    hi = mid - 1;
                } else {
                    return 0;
                }     
            } else {
                return mid;
            }
        } else {
            lo = 0;
            hi = nums.length - 1;
        }
        int mid = (lo + hi) / 2;
        while (lo <= hi) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            mid = (lo + hi) / 2;
        }
        return -1;
    }
}

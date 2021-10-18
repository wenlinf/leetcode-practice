class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[0], nums[1]);

        if (nums[0] > nums[nums.length - 1]) {
            int start = 0;
            int end = nums.length - 1;
            int mid = (start + end) / 2;
            while (start <= end) {
                if ((nums[mid] > nums[mid - 1]) && (nums[mid] > nums[mid + 1])) {
                    return nums[mid + 1];
                } else if ((nums[mid] > nums[mid - 1]) && (nums[mid] < nums[mid + 1])) {
                    if (nums[mid] < nums[start]) {
                        end = mid - 1;
                        start++;
                    } else if (nums[mid] > nums[end]) {
                        start = mid + 1;
                    } else {
                        end--;
                    }
                } else {
                    return nums[mid];
                }
                mid = (start + end) / 2;
            }
            return mid;
        } else {
            return nums[0];
        }
    }
}

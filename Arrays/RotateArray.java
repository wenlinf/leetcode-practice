class RotateArray {
    public void rotate(int[] nums, int k) {
        if (k >= nums.length) k = k % nums.length;
        if (nums.length == 1 || k == 0) return;
        int[] newArr = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - k) {
                newArr[i + k] = nums[i];
            } else {
                newArr[j] = nums[i];
                j++;
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            nums[i] = newArr[i];
        }
    }
    //modify the array in place
    public void rotate2(int[] nums, int k) {
        if (nums.length == 1) return;
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse (int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}

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
}

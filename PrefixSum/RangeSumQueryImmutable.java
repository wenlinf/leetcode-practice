class NumArray {
    private int[] sums;
    public NumArray(int[] nums) {
        int sum = 0;
        int n = nums.length;
        this.sums = new int[n+1];
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sums[i + 1] = sum;
        }
    }
    
    public int sumRange(int left, int right) {
        return this.sums[right + 1] - this.sums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

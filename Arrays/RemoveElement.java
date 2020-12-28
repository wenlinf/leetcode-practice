class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;
        int temp;
        while (start <= end) {
            if (nums[start] == val) {
                temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                end--;
            } else {
                start++;
            }
            
        }
        return start;
    }
}

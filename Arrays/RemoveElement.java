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
    
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = -1;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                slow++;
                nums[slow] = nums[fast];
            } 
            fast++;
        }
        return ++slow;
    }
}

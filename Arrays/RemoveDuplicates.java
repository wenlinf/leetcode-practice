class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int pointer = 1;
        while (pointer < nums.length) {
            if (nums[pointer] == nums[count]) {
                pointer++;
            } else {
                count++;
                nums[count] = nums[pointer];
                pointer++;
            }
        }
        return ++count;
    }
}

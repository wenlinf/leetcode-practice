class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int pointer = 1;
        while (pointer < nums.length) {
            if (nums[pointer] != nums[count]) {
                count++;
                nums[count] = nums[pointer];
            }
            pointer++;
        }
        return ++count;
    }
}

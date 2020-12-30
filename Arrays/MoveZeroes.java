class MoveZeroes {
    public void moveZeroes(int[] nums) {
            int count = 0;
            int[] newArr = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                 if (nums[i] == 0) {
                     count++;
                 } else {
                     newArr[i - count] = nums[i];
                 }
             }
            for (int i = 0; i < nums.length; i++) {
                 nums[i] = newArr[i];
             } 
    }
}

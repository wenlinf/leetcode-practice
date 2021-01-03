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
    public void moveZeroesInPlace(int[] nums) {
        int writePointer = 0;
        int readPointer = 0;
        while (readPointer < nums.length) {
           if (nums[readPointer] != 0) {
            nums[writePointer++] = nums[readPointer];
           } 
           readPointer++;
        }
        for (int i = writePointer; i < nums.length; i++) {
                nums[i] = 0;
        }
    }
}

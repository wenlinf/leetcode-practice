class DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i%2 == 0) size += nums[i];
        }
        int[] result = new int[size];
        size = 0;
        for (int i = 0; i < nums.length; i++) {     
            if (i%2 == 0) {
                for (int j = 0; j < nums[i]; j++) {
                    result[size + j] = nums[i+1];
                }
                size += nums[i];
            }  
        }
        return result;
    }
}

class MaxConsecutiveones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int temp = 0;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp++;
                if(i == nums.length-1 || nums[i+1] != 1) {
                    count = Math.max(temp,count);
                    temp = 0;
                }
            } 
        }
        return count;
    }
}
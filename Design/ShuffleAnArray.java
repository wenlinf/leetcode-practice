class Solution {
    private int[] original;
    private int[] shuffle;

    public Solution(int[] nums) {
        this.original = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            original[i] = nums[i];
        }
        this.shuffle = nums;
    }
    
    public int[] reset() {
        for (int i = 0; i < original.length; i++) {
            this.shuffle[i] = this.original[i];
        }
        return this.shuffle;
    }
    
    public int[] shuffle() {
        Random rand = new Random();
        for (int i = 0; i < shuffle.length; i++) {
            int index = rand.nextInt(shuffle.length);
            swap(i, index);
        }
        return this.shuffle;
    }

    private void swap(int i, int j) {
        int temp = shuffle[i];
        shuffle[i] = shuffle[j];
        shuffle[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

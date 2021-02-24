class Shuffle {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2*n];
        for (int i = 0; i < 2*n; i++) {
            if (i < n) {
                arr[i*2] = nums[i];
            } else {
                //4->1 5->3 6->5 7->7 0, 1, 2, 3
                arr[(i-n)*2+1] = nums[i];
            }
        }
        return arr;
    }
}

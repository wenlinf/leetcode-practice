class MovingAverage {
    private int[] nums;
    
    private int pt_start;
    private int pt_end;
    private int currSize;
    
    public MovingAverage(int size) {
        nums = new int[size];
        pt_start = 0;
        pt_end = -1;
    }
    
    public double next(int val) {
        int arrSize = this.nums.length;
        if (pt_end != -1 && pt_start == (pt_end + 1) % arrSize)  {
            nums[pt_start] = val;
            pt_end = pt_start;
            pt_start = (pt_start + 1) % this.nums.length;  
        } else {
            pt_end = (pt_end + 1) % this.nums.length;
            nums[pt_end] = val;
        }
       
        if (currSize < this.nums.length) {
            currSize++;
        }
        
        // calc average
        int sum = 0;
        for (int i = pt_start; i < pt_start + currSize; i++) {
            sum += nums[i % this.nums.length];
        }
        return (double)sum / (double)currSize;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

class Solution {
    private int[] temp;
    private int result;
    
    public int reversePairs(int[] nums) {
        int m = nums.length;
        this.temp = new int[m];
        mergeSort(nums, 0, m - 1);
        return result;
    }
    
    private void mergeSort(int[] nums, int lo, int hi) {
        if (lo == hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }
    
    private void merge(int[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }
        // for (int i = lo; i <= mid; i++) {
        //     for (int j = mid + 1; j <= hi; j++) {
        //         if ((long) nums[i] > (long) 2 * nums[j]) {
        //             this.result++;
        //         }
        //     }
        // }
        int end = mid + 1;
        for (int i = lo; i <= mid; i++) {
            while (end <= hi && (long)nums[i] > (long)2 * nums[end]) {
                end++;
            }
            result += end - (mid + 1);
        }
        
        int i = lo;
        int j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                nums[p] = temp[j++];
            } else if (j == hi + 1) {
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else if (temp[i] <= temp[j]) {
                nums[p] = temp[i++];
            }
        }
    }
}

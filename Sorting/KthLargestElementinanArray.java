class Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        int lo = 0;
        int hi = nums.length - 1;
        k = nums.length - k;
        while (lo <= hi) {
            int p = partition(nums, lo, hi);
            if (p > k) {
                hi = p - 1;
            } else if (p < k) {
                lo = p + 1;
            } else {
                return nums[p];
            }
        }
        return -1;
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo + 1;
        int j = hi;
        while (i <= j) {
            while (nums[i] <= pivot && i < hi) {
                i++;
            }
            while (nums[j] > pivot && j > lo) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }
    
    private void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = i + rand.nextInt(n - i);
            swap(nums, i , index);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Solution can be improved by inserting the smallest numbers first and keep the size of the heap to k
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            return n2 - n1;
        });
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            pq.remove();
        }
        return pq.poll();
    }
}

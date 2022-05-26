class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>(); 
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        this.count = count;
        
        int[] unique = new int[count.size()];
        int i = 0;
        for (int num: count.keySet()) {
            unique[i] = num;
            i++;
        }
        this.unique = unique;

        int lo = 0;
        int hi = unique.length - 1;
        shuffle(unique);
        quickSelect(lo, hi, k);
        return Arrays.copyOfRange(unique, count.size() - k, count.size());
    }
    
    private int[] unique;
    
    private void quickSelect(int lo, int hi, int k) {
        if (lo == hi) return;
        int n = unique.length;
        int pivot = partition(unique, lo, hi, count);
        if (pivot == n - k) {
            return;
        } else if (pivot < n - k) {
            lo = pivot + 1;
            quickSelect(lo, hi, k);
        } else {
            hi = pivot - 1;
            quickSelect(lo, hi, k);
        }
    }
    
    
    
    private Map<Integer, Integer> count;
    
    private int partition(int[] unique, int lo, int hi, Map<Integer, Integer> count) {
        int pivot = unique[hi];
        int l = lo - 1;
        int r = lo;
        while (r <= hi) {
            if (count.get(unique[r]) < count.get(pivot)) {
                l++;
                swap(unique, l, r);
            }
            r++;
        }
        l++;
        swap(unique, l, hi);
        return l;
        
    }
    
    private void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = i + rand.nextInt(n - i);
            swap(nums, i, index);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//There is another solution using heap. Link: https://github.com/wenlinf/leetcode-practice/blob/main/Heap/TopKFrequentElements.java

class Solution {
    private class Pair {
        int val;
        int id;
        Pair(int id, int val) {
            this.id = id;
            this.val = val;
        }
    }
    private Pair[] temp;
    private int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int m = nums.length;
        this.temp = new Pair[m];
        this.count = new int[m];
        Pair[] arr = new Pair[m];
        for (int i = 0; i < m; i++) {
            arr[i] = new Pair(i, nums[i]);
        }

        mergeSort(arr, 0, nums.length - 1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            result.add(count[i]);
        }
        return result;
    }
    
    private void mergeSort(Pair[] arr, int lo, int hi) {
        if (lo == hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }
    
    private void merge(Pair[] arr, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = arr[i];
        }
        
        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                arr[p] = temp[j++];
            } else if (j == hi + 1) {
                arr[p] = temp[i++];
                count[arr[p].id] += (j - mid - 1);
            } else if (temp[i].val > temp[j].val) {
                arr[p] = temp[j++];
            } else if (temp[j].val >= temp[i].val) {
                arr[p] = temp[i++];
                count[arr[p].id] += (j - mid - 1);
            }
        }
    }
}

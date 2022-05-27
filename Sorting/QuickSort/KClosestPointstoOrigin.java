class Solution {
    public int[][] kClosest(int[][] points, int k) {
        shuffle(points);
        int n = points.length;
        quickSelect(points, 0, n - 1, k);
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }
        return result;
    }
    
    private void quickSelect(int[][] points, int lo, int hi, int kth) {
        if (lo >= hi) return;
        int pivot = partition(points, lo, hi);
        if (pivot == kth) {
            return;
        } else if (pivot < kth) {
            lo = pivot + 1;
            quickSelect(points, lo, hi, kth);
        } else {
            hi = pivot - 1;
            quickSelect(points, lo, hi, kth);
        }
    }
    
    private Map<Integer, Integer> map;
    private int partition(int[][] points, int lo, int hi) {
        int[] pivot = points[hi];
        int l = lo - 1;
        int r = lo;
        while (r <= hi) {
            if (distance(points[r]) < distance(pivot)) {
                l++;
                swap(points, l, r);
            }
            r++;
        }
        l++;
        swap(points, l, hi);
        return l;
    }
    
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    private void shuffle(int[][] points) {
        Random rand = new Random();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            int index = i + rand.nextInt(n - i);
            swap(points, i, index);
        }
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}

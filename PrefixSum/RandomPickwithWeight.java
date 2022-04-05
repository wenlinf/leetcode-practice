class Solution {
    private int[] prefix;
    private int[] w;
    public Solution(int[] w) {
        this.w = w;
        int n = w.length;
        prefix = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            prefix[i] = prefix[i - 1] + w[i - 1];
        }
    }
    
    public int pickIndex() {
        Random rand = new Random();
        int n = prefix.length;
        int upperbound = prefix[n - 1];
        int randIndex = rand.nextInt(upperbound) + 1;
        int left = 0;
        int right = n - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (prefix[mid] == randIndex) {
                right = mid - 1;
            } else if (prefix[mid] > randIndex) {
                right = mid - 1;
            } else if (prefix[mid] < randIndex) {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

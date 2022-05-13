class Solution {
    public int numTrees(int n) {
        this.memo = new int[n + 1][n + 1];
        return helper(1, n);
    }
    
    private int[][] memo;
    private int helper(int start, int end) {
        if (start > end) return 0;
        if (start == end) return 1;
        if (memo[start][end] != 0) return memo[start][end];
        int count = 0;
        for (int i = start; i <= end; i++) {
            int left = helper(start, i - 1);
            int right = helper(i + 1, end);
            if (left == 0) {
                count += right;
            } else if (right == 0) {
                count+= left;
            } else {
                count += left * right;
            }
        }
        memo[start][end] = count;
        return count;
    }
}

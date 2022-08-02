class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{i, 0});
        }
        int index = 1;
        int[] top = new int[2];
        while (index <= k) {
            top = pq.poll();
            int row = top[0];
            int col = top[1];
            if (col + 1 < n) {
                pq.add(new int[]{row, col + 1});
            }
            index++;
        }
        return matrix[top[0]][top[1]];
    }
}

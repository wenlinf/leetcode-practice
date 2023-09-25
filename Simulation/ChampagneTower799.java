class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] arr = new double[query_row + 1][query_row + 1];
        arr[0][0] = (double)poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double amount = arr[i][j];
                if (arr[i][j] > 1) {
                    arr[i + 1][j + 1] += (arr[i][j] - 1.0) / 2.0;
                    arr[i + 1][j] += (arr[i][j] - 1.0) / 2.0;
                }
            }
        }
        return Math.min(1, arr[query_row][query_glass]);
    }
}

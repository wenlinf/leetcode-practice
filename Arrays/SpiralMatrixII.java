class Solution {
    public int[][] generateMatrix(int n) {
        int upperBound = 0;
        int lowerBound = n - 1;
        int leftBound = 0;
        int rightBound = n - 1;
        int[][] matrix = new int[n][n];
        int step = 1;
        while (step <= n * n) {
            for (int i = leftBound; i <= rightBound; i++) {
                matrix[upperBound][i] = step++;
            }
            upperBound++;
            for (int i = upperBound; i <= lowerBound; i++) {
                matrix[i][rightBound] = step++;
            }
            rightBound--;
            for (int i = rightBound; i >= leftBound; i--) {
                matrix[lowerBound][i] = step++;
            }
            lowerBound--;
            for (int i = lowerBound; i >= upperBound; i--) {
                matrix[i][leftBound] = step++;
            }
            leftBound++;
        }
        return matrix;
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int upperBound = 0;
        int leftBound = 0;
        int lowerBound = m - 1;
        int rightBound = n - 1;
        while (result.size() < m * n) {
            if (upperBound <= lowerBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    result.add(matrix[upperBound][i]);
                }
                upperBound++;
            }
            if (leftBound <= rightBound) {
                for (int i = upperBound; i <= lowerBound; i++) {
                    result.add(matrix[i][rightBound]);
                }
                rightBound--;
            }
            if (upperBound <= lowerBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    result.add(matrix[lowerBound][i]);
                }
                lowerBound--;
            }
            if (leftBound <= rightBound) {
                for (int i = lowerBound; i >= upperBound; i--) {
                    result.add(matrix[i][leftBound]);
                }
                leftBound++;
            }
        }
        return result;
    }
}

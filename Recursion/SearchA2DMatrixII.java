class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchRec(0, 0, matrix[0].length - 1,matrix.length - 1, matrix, target);
    }
    
    public boolean searchRec(int left, int up, int right, int down, int[][] matrix, int target) {
        if (left > right || up > down) return false;
        if (target < matrix[up][left] || target > matrix[down][right]) return false;
        
        int mid = left + (right - left) / 2;
        
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }
        return searchRec(mid + 1, up, right, row - 1, matrix, target)
            || searchRec(left, row, mid - 1, down, matrix, target);
    }
}

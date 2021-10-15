class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int column = matrix[0].length;
        int start = 0;
        int end = matrix.length - 1;
        int mid = (start + end) / 2;
        while (start < end) {
            if (target == matrix[mid][column - 1]) {
                return true;
            } else if (target > matrix[mid][column - 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
            mid = (start + end) / 2;
        }
        int index_in_array = end;
        start = 0;
        end = column - 1;
        mid = (start + end) / 2;
        while (start <= end) {
            if (target < matrix[index_in_array][mid]) {
                end = mid - 1;
            } else if (target > matrix[index_in_array][mid]) {
                start = mid + 1;
            } else {
                return true;
            }
            mid = (start + end) / 2;
        }
        return false;
    }
}

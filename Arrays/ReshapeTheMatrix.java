class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rowCount = mat.length;
        int columnCount = mat[0].length;
        if (r * c != rowCount * columnCount ) return mat;
        int[][] result = new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                result[(i * columnCount + j) / c][(i * columnCount + j) % c] = mat[i][j];
            }          
        }
        return result;
    }
}

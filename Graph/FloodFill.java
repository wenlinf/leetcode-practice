class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int origColor = image[sr][sc];
        if (origColor == newColor) return image;
        dfs(image, sr, sc, origColor, newColor);
        return image;
    }

    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private void dfs(int[][] image, int sr, int sc, int origColor, int newColor) {
        int m = image.length;
        int n = image[0].length;
        if (sr < 0 || sc < 0 || sr >= m || sc >= n) {
            return;
        }
        if (image[sr][sc] != origColor) return;
        image[sr][sc] = newColor;
        for (int[] dir : directions) {
            int x = dir[0];
            int y = dir[1];
            int row = sr + x;
            int col = sc + y;
            dfs(image, row, col, origColor, newColor);
        }
    }
}

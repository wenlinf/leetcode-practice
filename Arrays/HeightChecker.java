class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] sortedArr = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            sortedArr[i] = heights[i];
        }
        Arrays.sort(sortedArr);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (sortedArr[i] != heights[i]) count++;
        }
        return count;
    }
}

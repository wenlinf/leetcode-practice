class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = (height.length - 1) * Math.min(height[0], height[height.length - 1]);
        if (height.length == 2) return maxArea;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int startHeight = height[start];
            int endHeight = height[end];
            if (startHeight > endHeight) {
                while (start < end && height[end] <= endHeight) end--;
            } else if (startHeight < endHeight) {
                while (start < end && height[start] <= startHeight) start++;
            } else {
                while (start < end && height[end] <= endHeight && height[start] <= startHeight) {
                    start++;
                    end--;
                }
            }
            maxArea = Math.max(maxArea, (end - start) * Math.min(height[start], height[end]));
        }
        return maxArea;
    }
}

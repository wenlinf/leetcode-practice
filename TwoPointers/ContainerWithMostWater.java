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

// same thing labuladong more concise code
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[right], height[left]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}

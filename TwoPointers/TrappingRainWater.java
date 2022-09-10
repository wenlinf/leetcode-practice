//solution from labuladong
class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int result = 0;
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(l_max[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = Math.max(r_max[i + 1], height[i + 1]);
        }
        for (int i = 1; i < n; i++) {
            int l = l_max[i];
            if (l <= height[i]) continue;
            int r = r_max[i];
            if (Math.min(l, r) > height[i]) {
                result += Math.min(l, r) - height[i];
            }
        }
        return result;
    }
}

//solution from labuladong two pointers
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 1) return 0;
        int left = 0;
        int right = n - 1;
        int result = 0;
        int leftMax = height[0];a
        int rightMax = height[n - 1]; 
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax <= rightMax) {
                result += leftMax - height[left];
                left++;
            } else {
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }
}

class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] rightProduct = new int[nums.length];
        int[] leftProduct = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                leftProduct[i] = 1;
            } else {
                leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                rightProduct[i] = 1;
            } else {
                rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
            }
        }
        int[] result = new int[nums.length];
        for (int i = 0 ; i < nums.length; i ++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }
        return result;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = right * answer[i];
            right *= nums[i];
        }
        return answer;
    }
}

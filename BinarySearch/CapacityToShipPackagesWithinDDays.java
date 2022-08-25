class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int sum = 0;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += weights[i];
            min = Math.max(min, weights[i]);
        }
        int left = min;
        int right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2; 
            if (daysNeeded(weights, mid) <= days) {
                right = mid - 1;
            } else if (daysNeeded(weights, mid) > days) {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public int daysNeeded(int[] weights, int capacity) {
        int n = weights.length;
        int days = 0;
        int acc = 0;
        int i = 0;
        while (i < n) {
            while (i < n && acc + weights[i] <= capacity) {
              acc += weights[i];
              i++;  
            }
            days++;
            acc = 0;
        }
            
        return days;
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        
        int lo = 0;
        int hi = m;
        while (lo <= hi) {
            int half = (m + n + 1) / 2; // odd or even
            int midX = (lo + hi) / 2;
            int partY = half - midX;
            
            int xLeft = midX == 0 ? Integer.MIN_VALUE : nums1[midX - 1];
            int xRight = midX == m ? Integer.MAX_VALUE : nums1[midX];
            
            int yLeft = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int yRight = partY == n ? Integer.MAX_VALUE : nums2[partY];
            
            int lowMax = Math.max(xLeft, yLeft);
            int hiMin = Math.min(xRight, yRight);
            
            if (lowMax <= hiMin) {
                if ((m + n) % 2 == 0) {
                    return (double)(lowMax + hiMin) / 2;
                }
                return lowMax;
            }
            if (xLeft > yRight) {
                hi = midX;
            } else {
                lo = midX + 1;
            }
        }
        return -1;
    }
}

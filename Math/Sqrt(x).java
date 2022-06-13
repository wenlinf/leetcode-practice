class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int lo = 1; 
        int hi = x / 2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long square = (long)mid * mid;
            long square2 = (long) (mid + 1) * (mid + 1);
            if (square <= x && square2 > x) return mid;
            else if (square > x) {
                hi = mid - 1;
            } else if (square < x) {
                lo = mid + 1;
            }
        }
        return -1;
    }
}

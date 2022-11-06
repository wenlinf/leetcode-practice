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


// leetcode solution using Newton's method: https://www.youtube.com/watch?time_continue=525&v=cOmAk82cr9M&feature=emb_logo
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long seed = num / 2;
        while (seed * seed > num) {
            seed = (seed + num / seed) / 2;
        }
        return (seed * seed == num);
    }
}

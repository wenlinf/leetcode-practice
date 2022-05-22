class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        int[] result = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int[] booking = bookings[i];
            int start = booking[0] - 1;
            int end = booking[1] - 1;
            int incr = booking[2];
            diff[start] += incr;
            if (end < n - 1) {
                diff[end + 1] -= incr;
            }
        }
        result[0] = diff[0];
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        return result;
    }
}

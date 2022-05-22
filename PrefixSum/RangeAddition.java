class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        int[] arr = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int[] update = updates[i];
            int start = update[0];
            int end = update[1];
            int incr = update[2];
            diff[start] += incr;
            if (end < length - 1) {
                diff[end + 1] -= incr;
            }
        }
        arr[0] = diff[0];
        for (int i = 1; i <length; i++) {
            arr[i] = arr[i - 1] + diff[i];
        }
        return arr;
    }
}

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count = 0;
        int n = arr.length;
        int num = 1;
        int index = 0;
        while (index < n) {
            if (num != arr[index]) {
                count++;
            } else {
                index++;
            }
            if (count == k) return num;
            num++;
        }
        return num + (k - count) - 1;
    }
}

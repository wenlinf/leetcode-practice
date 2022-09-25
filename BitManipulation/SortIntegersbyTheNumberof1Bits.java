class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] - b[1] != 0) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int temp = num;
            int count = 0;
            while (num > 0) {
                if (num % 2 == 1) {
                    count++;
                }
                num /= 2;
            }
            pq.offer(new int[]{temp, count});
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int[] poll = pq.poll();
            result[i] = poll[0];
        }
        return result;
    }
}

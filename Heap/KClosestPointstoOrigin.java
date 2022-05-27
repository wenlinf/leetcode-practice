class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1] - a[1]);
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            pq.add(new int[]{i, point[0] * point[0] + point[1] * point[1]});
            if (pq.size() > k) {
                pq.remove();
            }
        }
        int[][] result = new int[k][2];
        int i = 0;
        while (pq.size()!= 0) {
            int[] el = pq.poll();
            result[i] = points[el[0]];
            i++;
        }
        return result;
    }
}

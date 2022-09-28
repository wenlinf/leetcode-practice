/* 
Time complexity: 
adding elements to the heap takes O(NlogN) time in total. 
The rest of the algo takes O(N).
So it's O(NlogN) in total.
Space complexity:
O(n) because of the priority queue
*/
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 && secondList.length == 0) return new int[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
            });
        for (int[] first : firstList) {
            pq.add(first);
        }
        for (int[] second : secondList) {
            pq.add(second);
        }
        List<int[]> list = new ArrayList<>();
        int[] prev = pq.poll();
        while (pq.size() != 0) {
            int[] curr = pq.poll();
            if (curr[0] < prev[1]) {
                if (prev[1] < curr[1]) {
                    list.add(new int[]{curr[0], prev[1]});
                    prev = curr;
                } else {
                    list.add(new int[]{curr[0], curr[1]});
                } 
            } else if (curr[0] == prev[1]) {
                list.add(new int[]{curr[0], curr[0]});
                prev = curr;
            } else {
                prev = curr;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}

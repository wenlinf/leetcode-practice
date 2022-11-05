class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[i - 1]) {
                if (ladders == 0 && bricks == 0) return i - 1;
                int diff = heights[i] - heights[i - 1];
                if (ladders == 0) {
                    if (pq.size() > 0 && pq.peek() < diff) {
                        int min = pq.poll();
                        bricks -= min;
                        if (bricks < 0) return i - 1;
                        pq.add(diff);
                    } else {
                        bricks -= diff;
                        if (bricks < 0) return i - 1;
                    }
                } else {
                    ladders--;
                    pq.add(diff);
                }
            }
        }
        if (bricks >= 0 || ladders >= 0) return heights.length - 1;
        return -1;
    }
}

// solution from leetcode official
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                pq.add(diff);
                if (pq.size() > ladders) {
                    int min = pq.poll();
                    bricks -= min;
                    if (bricks < 0) return i - 1;
                }
            }
        }
        return heights.length - 1;
    }
}

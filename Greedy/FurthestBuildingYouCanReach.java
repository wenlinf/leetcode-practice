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

// solution using max heap, same idea
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                pq.add(diff);
                bricks -= diff;
                if (bricks < 0) {
                    int max = pq.poll();
                    bricks += max;
                    ladders--;
                    if (ladders < 0) return i - 1;
                }
            }
        }
        return heights.length - 1;
    }
}

// binary search solution from leetcode
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int lo = 0;
        int hi = heights.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (reachable(heights, bricks, ladders, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private boolean reachable(int[] heights, int bricks, int ladders, int index) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= index; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                pq.add(diff);
            }
        }
        while (pq.size() > 0) {
            int min = pq.poll();
            if (bricks >= min) {
                bricks -= min;
            } else if (ladders > 0) {
                ladders--;
            } else {
                return false;
            }
            
        }
        return true;
    }
}

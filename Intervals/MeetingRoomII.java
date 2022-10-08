class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) return 1;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        
        pq.add(intervals[0]);
        int result = 1;
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            if (pq.size() != 0) {
                int[] top = pq.peek();
                if (top[1] <= interval[0]) {
                    pq.poll();
                    pq.add(interval);
                } else {
                    result++;
                    pq.add(interval);
                }
            }
        }
        return result;
    }
}


class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) return 1;
        
        int[] begin = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            begin[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);
        
        int count = 0;
        int result = 0;
        int pt1 = 0;
        int pt2 = 0;
        while (pt1 < n) {
            if (begin[pt1] < end[pt2]) {
                count++;
                pt1++;
                result = Math.max(count, result);
            } else {
                count--;
                pt2++;
            }
        }
        return result;
    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;
        for (int[] interval : intervals) {
            if (pq.size() != 0) {
                int earliestEnd = pq.poll();
                if (earliestEnd <= interval[0]) {
                    pq.offer(interval[1]);
                } else {
                    result++;
                    pq.offer(interval[1]);
                    pq.offer(earliestEnd);
                }
            } else {
                result++;
                pq.offer(interval[1]);
            }
        }
        return result;  
    }
}

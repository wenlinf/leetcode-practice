class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> timestamp = new TreeMap<>();

        for (int[] interval : intervals) {
            int from = interval[0];
            int to = interval[1];
            int start = timestamp.getOrDefault(from, 0) + 1;
            timestamp.put(from, start);
            int end = timestamp.getOrDefault(to , 0) - 1;
            timestamp.put(to, end);
        }
        
        int max = 0;
        int res = 0;
        for (int change : timestamp.values()) {
            res += change;
            max = Math.max(max, res);
        }
        return max;
    }
}

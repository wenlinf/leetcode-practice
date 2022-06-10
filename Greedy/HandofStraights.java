class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(hand[i]);
        }
        while (!pq.isEmpty()) {
            int val = pq.poll();
            for (int i = 1; i < groupSize; i++) {
                if (!pq.remove(val + i)) return false;
            }
        }
        return true;
    }
}


class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        
        while (map.size() != 0) {
            int val = map.firstKey();
            for (int i = 1; i < groupSize; i++) {
                if (!map.containsKey(val + i)) return false;
                if (map.get(val+i) == 1) map.remove(val+i);
                else map.put(val+i, map.get(val+i) - 1);
            }
            if (map.get(val) == 1) map.remove(val);
            else map.put(val, map.get(val) - 1);
        }
        return true;
    }
}

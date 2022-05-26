class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            return freq.get(n2) - freq.get(n1);
        });
        for (Map.Entry<Integer,Integer> entry: freq.entrySet()) {
            pq.add(entry.getKey());
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.remove();
        }
        return result;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));
            pq.addAll(freq.keySet());
        
        int count = 0;
        

        while (!pq.isEmpty()) {
            int interval = n + 1;
            List<Character> waitlist = new ArrayList<>();

            while (interval > 0 && !pq.isEmpty()) {
                Character ch = pq.poll();
                freq.put(ch, freq.get(ch) - 1);
                if (freq.get(ch) != 0) {
                    waitlist.add(ch);
                }
                interval--;
                count++;
            }
            if (pq.isEmpty() && interval != 0) {
                if (waitlist.size() != 0) {
                    count+= interval;
                }
            }
            pq.addAll(waitlist);
        } 
            
        return count;
            
    }
}

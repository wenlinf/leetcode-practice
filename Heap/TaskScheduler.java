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

// solution from Neetcode
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> count = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (char task : tasks) {
            count.put(task, count.getOrDefault(task, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            pq.add(entry.getValue());
        }
        int time = 0;
        while (pq.size() != 0 || queue.size() != 0) {
            time++;
            if (pq.size() != 0) {
                int val = pq.poll();
                val--;
                if (val > 0) {
                    queue.add(new Pair<>(val, time + n));
                }
                
            }
            if (queue.size() != 0 && queue.peek().getValue() == time) {
                pq.add(queue.poll().getKey());
            }
        }
        return time;
    }
}

class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> two = new ArrayList<>();
        two.add(2);
        List<Integer> three = new ArrayList<>();
        three.add(3);
        List<Integer> five = new ArrayList<>();
        five.add(5);
        List<Integer> result = new ArrayList<>();
        int pt1 = 0; 
        int pt2 = 0;
        int pt3 = 0;
        int index = 1;
        result.add(1);
        while (index < n) {
            int next = Math.min(two.get(pt1), Math.min(three.get(pt2), five.get(pt3)));
            result.add(next);
            index++;
            if (next == two.get(pt1)) {
                pt1++;
                two.add(result.get(pt1) * 2);
            }
            if (next == three.get(pt2)) {
                pt2++;
                three.add(result.get(pt2) * 3);
            }
            if (next == five.get(pt3)) {
                pt3++;
                five.add(result.get(pt3) * 5);
            }
            
        }
        return result.get(n - 1);
    }
}

//solution using heap. Have to take care of overflow. Use long and then convert to int
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        pq.offer(1L);
        seen.add(1L);
        int index = 0;
        
        while (index < n - 1) {
            long top = pq.poll();
            if (!seen.contains(top * 2)) {
                pq.offer(top * 2);
                seen.add(top * 2);
            }
            if (!seen.contains(top * 3)) {
                pq.offer(top * 3);
                seen.add(top * 3);
            }
            if (!seen.contains(top * 5)) {
                pq.offer(top * 5);
                seen.add(top * 5);
            }
            index++;
        }
        long result = pq.poll();
        return (int)result;
    }
}

class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i],map.getOrDefault(nums[i], 0) + 1); 
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a) > map.get(b)) {
                return 1;
            } else if (map.get(a) < map.get(b)) {
                return -1;
            } else {
                if (a > b) {
                    return -1;
                } else if (a < b) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            pq.add(nums[i]);
        }
        int[] result = new int[n];
        int i = 0;
        while (i < n) {
            result[i++] = pq.poll();
        }
        return result;
    }
}


class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            list.add(nums[i]);
        }
        
        Collections.sort(list, (a, b) -> {
            if (map.get(a) > map.get(b)) {
                return 1;
            } else if (map.get(a) == map.get(b)) {
                return b - a;
            } else {
                return -1;
            }
        });
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int num : nums) {
            count[num]++;
        }
        int avoid = 0;
        int using = 0;
        int prev = -1;
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                list.add(i);
            }
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            int m = Math.max(avoid, using);
            if (list.get(i) - 1 != prev) {
                using = list.get(i) * count[list.get(i)] + m;
                avoid = m;
            } else {
                using = list.get(i) * count[list.get(i)] + avoid;
                avoid = m; 
            }
            prev = list.get(i);
        }
        return Math.max(avoid, using);
    }
}

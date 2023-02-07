class Solution {
    public int totalFruit(int[] fruits) {
        int right = 0;
        int left = 0;
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int curr_sum = 0;
        for (right = 0; right < n; right++) {
            int fruit = fruits[right];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
            curr_sum += 1;
            while (map.size() > 2) {
                int leftFruit = fruits[left];
                int num = map.get(leftFruit);
                map.put(leftFruit, num - 1);
                if (num - 1 == 0) {
                    map.remove(leftFruit);
                }
                curr_sum -= 1;
                left++;
            }
            max = Math.max(max, curr_sum);
        }
        return max;
    }
}

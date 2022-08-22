class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = position.length;
        for (int i = 0; i < n; i++) {
            map.put(position[i], speed[i]);
        }
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(position);

        for (int i = n - 1; i >= 0 ; i--) {
            if (stack.isEmpty()) {
                stack.push(position[i]);
            } else {
                int top = stack.pop();
                double prevTime = (double)(target - top) / map.get(top);
                double currTime = (double)(target - position[i]) / map.get(position[i]);
                if (Double.compare(currTime, prevTime) > 0) {
                    stack.push(top);
                    stack.push(position[i]);
                } else {
                    stack.push(top);
                }
            }
        }
        return stack.size();
    }
}

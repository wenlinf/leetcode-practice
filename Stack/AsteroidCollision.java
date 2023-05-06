class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean push = true;
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (Math.abs(asteroid) > stack.peek()) {
                    stack.pop();
                } else if (Math.abs(asteroid) == stack.peek()) {
                    stack.pop();
                    push = false; 
                    break;
                } else {
                    push = false;
                    break;
                }
            }
            if (push) {
                stack.push(asteroid);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}

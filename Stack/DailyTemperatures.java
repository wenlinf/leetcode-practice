class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        ans[ans.length - 1] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(ans.length - 1);
        int index = temperatures.length - 1;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            if (stack.isEmpty()) {
                temperatures[i] = 0;
            } else if (temperatures[stack.peek()] > temperatures[i]) {
                ans[i] = stack.peek() - i;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    ans[i] = stack.peek() - i;
                }
                stack.push(i);
            }
        }
        return ans;
    }
}

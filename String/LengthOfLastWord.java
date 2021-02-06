class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') stack.push(i);
        }
        if (stack.isEmpty()) return s.length();
        Integer index = stack.pop();
        return s.length() - 1 - index;
    }
}

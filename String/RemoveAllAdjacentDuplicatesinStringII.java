//All solutions from leetcode
//brute force TLE
class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        if (n == 1) return s;
        StringBuilder sb = new StringBuilder(s);
        int prevLength = -1;
        while (prevLength != sb.length()) {
            prevLength = sb.length();
            int count = 1;
            for (int i = 0; i < sb.length(); i++) {
                if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                    count = 1;
                } else {
                    count++;
                    if (count == k) {
                        sb.delete(i - count + 1, i + 1);
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}

// Memoize the counts
class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        if (n == 1) return s;
        StringBuilder sb = new StringBuilder(s);
        int prevLength = -1;
        int[] counts = new int[n];
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts[i] = 1;
            } else {
                counts[i] = counts[i - 1] + 1;
                if (counts[i] == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }
        return sb.toString();
    }
}

// use stack to store counts
class Solution {
    public String removeDuplicates(String s, int k) {
        if (s.length() == 1) return s;
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                stack.push(1);
            } else {
                int newCount = stack.pop() + 1;
                if (newCount == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    stack.push(newCount);
                }
            }
        }
        return sb.toString();
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        if (s.length() == 1) return s;
        StringBuilder sb = new StringBuilder(s);
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                stack.push(new Pair(sb.charAt(i), 1));
            } else {
                Pair<Character, Integer> pair = stack.pop();
                int newCount = pair.getValue() + 1;
                if (newCount == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    stack.push(new Pair(pair.getKey(), newCount));
                }
            }
        }
        return sb.toString();
    }
}

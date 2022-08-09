class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        for (String deadend : deadends) {
            deadSet.add(deadend);
        }
        if (deadSet.contains("0000")) return -1;
        LinkedList<String> queue = new LinkedList<>();
        queue.add("0000");
        Set<String> seen = new HashSet<>();
        int moves = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                String first = queue.poll();
                if (first.equals(target)) return moves;
                seen.add(first);
                char[] arr = first.toCharArray();
                for (int i = 0; i < 4; i++) {
                    char temp = first.charAt(i);
                    int digit = temp - '0';
                    int minus = 0;
                    if (digit == 0) {
                        minus = 9;
                    } else {
                        minus = digit - 1;
                    }
                    int plus = 0;
                    if (digit == 9) {
                        plus = 0;
                    } else {
                        plus = digit + 1;
                    }
                    arr[i] = (char)(minus + '0');
                    String next = String.valueOf(arr);
                    if (!seen.contains(next) && !deadSet.contains(next)) {
                        seen.add(next);
                        queue.add(next);
                    }
                    arr[i] = (char)(plus + '0');
                    next = String.valueOf(arr);
                    if (!seen.contains(next) && !deadSet.contains(next)) {
                        seen.add(next);
                        queue.add(next);
                    }
                    arr[i] = temp;
                    
                }
                levelSize--;   
            }
            moves++; 
        }
        return -1;
    }
}

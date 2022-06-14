class Solution {
    public int myAtoi(String s) {
        String temp = s.trim();
        StringBuilder sb = new StringBuilder();
        int n = temp.length();
        boolean negative = false;
        boolean startsWithNonZero = false;
        boolean started = false;
        for (int i = 0; i < n; i++) {
            char ch = temp.charAt(i);
            
            if (i == 0 && ch == '-') {
                negative = true;
                started = true;
            } else if (i == 0 && ch == '+') {
                started = true;
            } else if (i == 0 && !Character.isDigit(ch) && ch != '-') {
                break;
            } else {
                // Character.isDigit()
                if (!Character.isDigit(ch)) {
                    if (started) {
                        break;
                    }
                    continue;
                } else {
                    started = true;
                    if (ch != '0') {
                        startsWithNonZero = true;
                    }
                    if (startsWithNonZero) {
                        sb.append(ch);
                    }
                }
            }    
        }
        // deal with overflow
        if (sb.length() == 0) return 0;
        if (!negative && sb.length() > 10) return Integer.MAX_VALUE;
        if (negative && sb.length() > 10) return Integer.MIN_VALUE;
        Long number = Long.parseLong(sb.toString());
        if (!negative) {
            if (number > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return number.intValue();
        } else {
            number = 0 - number;
            if (number < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return number.intValue();
            }
        }
    }
}

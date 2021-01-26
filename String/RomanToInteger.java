class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i != s.length() - 1) 
                && s.charAt(i) == 'I') {
                if (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X') result -= 1;
                else result += 1;
            } else if (i != s.length() - 1 
                && s.charAt(i) == 'X' ) {
                if (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C') result -= 10;
                else result += 10;
            } else if (i != s.length() - 1 
                && s.charAt(i) == 'C') {
                if (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M') result -= 100;
                else result += 100;
            } else {
                result += valueOfChar(s.charAt(i));
            }      
        }
        return result;
    }
    private int valueOfChar(char ch) {
        int result = 0;
        if (ch == 'I') result = 1;
        if (ch == 'V') result = 5;
        if (ch == 'X') result = 10;
        if (ch == 'L') result = 50;
        if (ch == 'C') result = 100;
        if (ch == 'D') result = 500;
        if (ch == 'M') result = 1000;
        return result;
    }
}

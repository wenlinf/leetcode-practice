class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;    
        for (int i = 0; i < s.length() - 1; i++) {
            int val = valueOfChar(s.charAt(i));
                if (val < valueOfChar(s.charAt(i + 1))) result -= val;
                else result += val;   
        }
        return result + valueOfChar(s.charAt(s.length() - 1));
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

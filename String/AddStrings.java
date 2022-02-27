class Solution {
    public String addStrings(String num1, String num2) {
        int maxLen = Math.max(num1.length(), num2.length());
        int digit1;
        int digit2;
        int sumDigit;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            digit1 = i > num1.length() - 1 ? 0 : num1.charAt(num1.length() - 1 - i) - '0';
            digit2 = i > num2.length() - 1 ? 0 : num2.charAt(num2.length() - 1 - i) - '0';
            sumDigit = digit1 + digit2;
            if (carry == 1) {
                sumDigit ++;
            }
            if (sumDigit >= 10) {
                carry = 1;
                sumDigit = sumDigit % 10;
            } else {
                carry = 0;
            }
            sb.append((char)(sumDigit + '0'));
        }
        if (carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
    
}

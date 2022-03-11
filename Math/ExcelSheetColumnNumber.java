class Solution {
    public int titleToNumber(String columnTitle) {
        int strLen = columnTitle.length();
        int result = 0;
         for (int i = strLen - 1; i >= 0; i--) {
             int mul = (int)Math.pow(26, strLen - i - 1);
             result += (columnTitle.charAt(i) - 'A' + 1) * mul;
         }
        return result;
    }
}

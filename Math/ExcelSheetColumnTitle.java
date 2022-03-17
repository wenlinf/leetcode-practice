class Solution {
    public String convertToTitle(int columnNumber) {
        int digit = 0;
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            digit = columnNumber % 26;
            sb.append((char)(digit + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}

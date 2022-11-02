// solution from : https://leetcode.com/problems/nth-digit/discuss/334907/Just-wanted-to-share-my-Java-solution-too-with-easy-explanation.-The-submit-gives-100-fast.
class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        int numOfDigitsInInterval = 9;
        while (n - numOfDigitsInInterval > 0) {
            n -= numOfDigitsInInterval;
            digit += 1;
            numOfDigitsInInterval = (int)(9 * Math.pow(10, (digit - 1)) * digit);
            if (n - numOfDigitsInInterval < 0) break;
        }
        int base = (int)Math.pow(10, digit - 1);
        int number = base + (n - 1) / digit;
        String str = String.valueOf(number);
        char ch = str.charAt((n - 1) % digit);
        return ch - '0';
    }
}

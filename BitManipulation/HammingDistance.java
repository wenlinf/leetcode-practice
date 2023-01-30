class Solution {
    public int hammingDistance(int x, int y) {
        int hammingDistance = 0;
        while (x != 0 || y != 0) {
            int digit1 = x % 2;
            int digit2 = y % 2;
            if (digit1 != digit2) hammingDistance++;
            x = x / 2;
            y = y / 2;
        }
        return hammingDistance;
    }
}

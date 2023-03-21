class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            int bed = flowerbed[i];
            if (bed == 0) {
                boolean leftEmpty = i - 1 >= 0 ? flowerbed[i - 1] == 0 : true;
                boolean rightEmpty = i + 1 < m ? flowerbed[i + 1] == 0 : true;
                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
}

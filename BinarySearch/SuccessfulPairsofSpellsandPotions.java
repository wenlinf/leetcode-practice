class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        /**
        sort potions array
        traverse spells, find numbers in potions using binary search
        - use long to store products - overflow
        */
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            long minPotion = (long)Math.ceil(1.0 * success / spell);
            if (minPotion > potions[m - 1]) continue;
            int leftBound = binarySearch(potions, minPotion);

            res[i] = m - leftBound;
        }
        return res;
    }

    private int binarySearch(int[] potions, long target) {
        int m = potions.length;
        int lo = 0; 
        int hi = m - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (potions[mid] == target) {
                hi = mid - 1;
            } else if (potions[mid] < target) {
                lo = mid + 1;
            } else if (potions[mid] > target) {
                hi = mid - 1;
            }
        }
        return lo;
    }
}

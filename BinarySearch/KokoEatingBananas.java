class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = findMax(piles);
        int left = 0;
        int right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int finishTime = canFinish(piles, mid, h);
            if (finishTime == 0) {
                right = mid - 1;
            } else if (finishTime > 0) {
                right = mid - 1;
            } else if (finishTime < 0) {
                left = mid + 1;
            }
            if (right == 0) return 1;
            
        }
        if (left == max + 1) return max;
        return left;
    }
    
    private int findMax(int[] piles) {
        int n = piles.length;
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }
    
    private int canFinish(int[] piles, int speed, int time) {
        int n = piles.length;
        int need = 0;
        for (int i = 0; i < n; i++) {
            if (piles[i] <= speed) {
                need++;
            } else {
                if (piles[i] % speed == 0) {
                    need += piles[i] / speed;
                } else {
                    need += (piles[i] / speed + 1);
                }
            }
        }
        return time - need;
    }
}

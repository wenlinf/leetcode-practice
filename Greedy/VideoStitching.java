class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        
        if (clips[0][0] != 0) return -1;
        int end = 0;
        int nextEnd = 0;
        int result = 0;
        int i = 0;
        int n = clips.length;
        while (i < n) {
            if (clips[i][0] <= end) {
                while (i < n && clips[i][0] <= end) {
                    nextEnd = Math.max(nextEnd, clips[i][1]);
                    i++;
                } 
                result++;
                end = nextEnd;
                if (end >= time) return result;
            } else {
                break;
            }
        }
        return -1;
    }
}

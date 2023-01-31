class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        List<int[]> combine = new ArrayList<>();
        int n = ages.length;
        for (int i = 0; i < n; i++) {
            int[] list = new int[]{ages[i], scores[i]};
            combine.add(list);
        }
        combine.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int[] dp = new int[n];
        dp[0] = combine.get(0)[1];
        int answer = dp[0];
        for (int i = 1; i < n; i++) {
            int currScore = combine.get(i)[1];
            int currAge = combine.get(i)[0];
            int maxScore = 0;
            for (int j = 0; j < i; j++) {
                int prevScore = combine.get(j)[1];
                int prevAge = combine.get(j)[0]; 
                if (prevScore <= currScore) {
                    maxScore = Math.max(maxScore, dp[j]);
                }
            }
            dp[i] = maxScore + currScore;
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        // List<Integer> list = new ArrayList<>();
        // for (int i = 0; i < days.length; i++) {
        //     list.add(days[i]);
        // }
        int dayIndex = 0;
        for (int i = 1; i <= 365; i++) {
            if (dayIndex == days.length) break;
            if (i != days[dayIndex]) {
                dp[i] = dp[i - 1];
            } else {
                int one =costs[0] + dp[i - 1];
                int seven = costs[1] + dp[Math.max(0, i - 7)];
                int thirty = costs[2] + dp[Math.max(0, i - 30)];
                dp[i] = Math.min(one, Math.min(seven, thirty));
                dayIndex++;
            }
            
        }
        return dp[days[days.length - 1]];
    }
}

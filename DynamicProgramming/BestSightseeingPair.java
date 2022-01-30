class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] values) {   
        int addition = values[0] + 0;
        int subtraction = 0;
        int maxScore = 0;
        for (int i = 1; i < values.length; i++) {
            subtraction = values[i] - i;
            maxScore = Math.max(maxScore, subtraction + addition);
            addition = Math.max(addition, values[i] + i);
        }
        return maxScore;
    }
}

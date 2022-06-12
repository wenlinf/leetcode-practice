class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        int targetOne = target[0];
        int targetTwo = target[1];
        int targetThree = target[2];
        
        int result1 = -1;
        int result2 = -1;
        int result3 = -1;
        for (int i = 0; i < n; i++) {
            int[] triplet = triplets[i];
            int first = triplet[0];
            int second = triplet[1];
            int third = triplet[2];
            if ((first > targetOne || second > targetTwo || third > targetThree) ||
               (first < targetOne && second < targetTwo && third < targetThree)) {
                continue;
            }
            result1 = Math.max(result1, first);
            result2 = Math.max(result2, second);
            result3 = Math.max(result3, third);
        }
        return ((result1 == targetOne) && (result2 == targetTwo) && (result3 == targetThree));
    }
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        int row = triangle.size();
        for (int i = 0; i < row; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(triangle.get(0).get(0));
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int curr = triangle.get(i).get(j);
                if (j == 0) {
                    dp.get(i).add(dp.get(i - 1).get(0) + curr);
                } else if (j == triangle.get(i).size() - 1) {
                    dp.get(i).add(dp.get(i - 1).get(j - 1) + curr);
                } else {
                    dp.get(i).add(curr + Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)));
                }
            }
        }
        int result = Integer.MAX_VALUE;
        int lastRow = triangle.get(row - 1).size();
        
        for (int i = 0; i < lastRow; i++) {
            result = Math.min(dp.get(row - 1).get(i), result);
        }
        return result;
    }
}

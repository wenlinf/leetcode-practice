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


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // List<List<Integer>> dp = new ArrayList<>();
        List<Integer> prev = triangle.get(0);
        int row = triangle.size();

        // dp.get(0).add(triangle.get(0).get(0));
        for (int i = 1; i < row; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int currNum = triangle.get(i).get(j);
                if (j == 0) {
                    curr.add(prev.get(0) + currNum);
                } else if (j == i) {
                    curr.add(prev.get(j - 1) + currNum);
                } else {
                    curr.add(Math.min(prev.get(j), prev.get(j - 1)) + currNum);
                }
            }
            prev = curr;
        }
        int result = Integer.MAX_VALUE;
        int lastRow = prev.size();
        
        for (int i = 0; i < lastRow; i++) {
            result = Math.min(prev.get(i), result);
        }
        return result;
    }
}

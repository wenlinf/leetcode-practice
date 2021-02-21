class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) return result;
        for (int i = 0; i < numRows; i++) {
            Integer[] rowArr = new Integer[i+1];
            for (int j = 0; j < i+1; j++) {
                if (j == 0 || j == i ) {
                    rowArr[j] = 1;
                } else {
                    rowArr[j] = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                }   
            }
            result.add(Arrays.asList(rowArr));
        }
        return result;
    }
}

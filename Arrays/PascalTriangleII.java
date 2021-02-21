class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (rowIndex == 0) return list;
        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i <= rowIndex; i++) {
            list.clear();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) list.add(1);
                else list.add(temp.get(j) + temp.get(j-1));
            }
            temp = List.copyOf(list);
        }
        return list;
    }
}

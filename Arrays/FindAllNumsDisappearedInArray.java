class FindAllNumsDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int index;
        for (int num: nums) {
            index = Math.abs(num) - 1;
            nums[index] = -Math.abs(nums[index]);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}

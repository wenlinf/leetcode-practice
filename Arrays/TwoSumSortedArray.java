class TwoSumSortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int pt1 = 0;
        int pt2 = numbers.length - 1;
        int[] result = new int[2];
        while (pt1 < pt2) {
            if (numbers[pt1] + numbers[pt2] > target) {
                pt2--;
            } else if (numbers[pt1] + numbers[pt2] < target) {
                pt1++;
            } else {
                result[0] = pt1 + 1;
                result[1] = pt2 + 1;
                break;
            }
        }
        return result;
    }
}

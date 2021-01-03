class ThirdMaxNum {
    public int thirdMax(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        int count = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int[] arr = new int[set.size()];
        int k = 0;
        for (Integer i: set) {
            arr[k++] = i;   
        } 
        Arrays.sort(arr);
        if (arr.length < 3) return arr[arr.length - 1];
        return arr[arr.length - 3];
    }
}

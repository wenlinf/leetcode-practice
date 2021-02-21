class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
            if (nums.length == 0) return result;
            if (nums.length == 1) {
                result.add(Integer.toString(nums[0]));
            } 
            int start = nums[0];
            int end = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i-1] + 1) {
                    end = nums[i];
                    if (i == nums.length -1) result.add(start+"->"+end);
                } else {
                    if (start == end) {
                        result.add(Integer.toString(start));
                    } else {
                        result.add(start+"->"+end);
                    }
                    start = nums[i];
                    end = nums[i];
                    if (i == nums.length -1) result.add(Integer.toString(nums[i]));
                }

            }
            return result;
    }
}

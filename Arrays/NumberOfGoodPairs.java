class NumberOfGoodPairs {
            public int numIdenticalPairs(int[] nums) {
                Arrays.sort(nums);
                int temp = 1;
                int count = 0;
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i] == nums[i-1]) {
                        temp++;
                    } else {
                        if (temp > 1) count+= temp*(temp-1)/2;
                        temp = 1;
                    }
                }
                if (temp > 1) count+=temp*(temp-1)/2;
                return count;
            }
}

class SortColors {
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i < count0) {
                nums[i] = 0;
            } else if (i < count0 + count1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
    
    public void sortColorsTwoPointers(int[] nums) {
        int pt0 = 0;
        int pt2 = nums.length - 1;
        
        int curr = 0;
        while (curr <= pt2) {
            if (nums[curr] == 0 && curr != pt0) {
                nums[curr] = nums[pt0];
                nums[pt0] = 0;  
                pt0++;
            } else if (nums[curr] == 2) {
                nums[curr] = nums[pt2];
                nums[pt2] = 2;
                pt2--;
            } else {
                curr++;
            }  
        }
    }
}

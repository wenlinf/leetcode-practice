class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int temp = 0;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp++;
                if(i == nums.length-1 || nums[i+1] != 1) {
                    count = Math.max(temp,count);
                    temp = 0;
                }
            } 
        }
        return count;
    }
}


//A better solution from: https://medium.com/@saurav.agg19/max-consecutive-ones-c419cc842ae4
// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {
//         int max = 0;
//         int current = 0;
//         for (int i : nums) {
//             if (i == 1) {
//                 current++;
//             } else {
//                 if (current > max) {
//                     max = current;
//                 }
//                 if (max >= nums.length / 2) {
//                     return max;
//                 }
//                 current = 0;
//             }
//         }
//         return Math.max(max, current);
//     }
// }
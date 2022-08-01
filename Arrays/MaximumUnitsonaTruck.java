class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int num = boxTypes.length;
        int size = 0;
        int max = 0;
        for (int i = 0; i < num; i++) {
            int[] box = boxTypes[i];
            int numBox = box[0];
            int numUnits = box[1];
            if (size < truckSize) {
                if (numBox <= truckSize - size) {
                    size += numBox;
                    max += numBox * numUnits;
                } else {
                    max += (truckSize - size) * numUnits;
                    size += truckSize - size;
                }
            }
            if (size == truckSize) break;
        }
        return max;
    }
    
}

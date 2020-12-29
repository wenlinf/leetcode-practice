class CheckIfNandItsDoubleExist {
 public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] * 2)) {
                return true;
            }
            if (arr[i] % 2 == 0) {
                if (map.containsKey(arr[i] / 2)) {
                    return true;
                }
            }
            map.put(arr[i], null);
        }
        return false;
    }
}

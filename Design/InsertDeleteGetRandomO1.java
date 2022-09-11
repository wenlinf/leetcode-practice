//checked leetcode solution
class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        int n = list.size();
        list.add(n, val);
        map.put(val, n);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        int n = list.size();
        int lastElement = list.get(n - 1);
        map.put(lastElement, index);
        list.set(index, lastElement);
        list.remove(n - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int n = list.size();
        Random rand = new Random();
        int randIdx = rand.nextInt(n);
        return list.get(randIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

class RandomizedCollection {

    private Map<Integer, Set<Integer>> map;
    private LinkedList<Integer> list;
    public RandomizedCollection() {
        this.map = new HashMap<>();
        this.list = new LinkedList<>();
    }
    
    public boolean insert(int val) {
        
        if (!map.containsKey(val)) {
            map.put(val, new LinkedHashSet<>());

        }
        map.get(val).add(list.size());
        list.add(val);
        return map.get(val).size() == 1;
        
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0) {
            return false;
        }
        // get a random index of the val in the set
        int removeIndex = map.get(val).iterator().next();
        // remove the index from the set
        map.get(val).remove(removeIndex);
        
        // get the last number from the list
        int lastNum = list.get(list.size() - 1);
        // set the number at the index to be the last number and add this index to the set
        list.set(removeIndex, lastNum);
        // remove the original index of the last number from the set
       Set<Integer> set = map.get(lastNum);
        map.get(lastNum).add(removeIndex); // order!
        map.get(lastNum).remove(list.size() - 1);//order!
         
        
        // remove the last number in the list
        list.removeLast();
        
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int randIdx = rand.nextInt(list.size());
        return list.get(randIdx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

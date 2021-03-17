class MyHashSet {
    private static final int size = 1000001;
    private final int[] myHashSet;
    /** Initialize your data structure here. */
    public MyHashSet() {
        myHashSet = new int[size];
        myHashSet[0] = -1;
    }
    
    public void add(int key) {
        myHashSet[key] = key;
    }
    
    public void remove(int key) {
        if (key == 0) myHashSet[key] = -1;
        else myHashSet[key] = 0;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(key != 0 && myHashSet[key] == 0) return false;
        if (key == 0 && myHashSet[key] == -1) return false;
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

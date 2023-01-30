class LFUCache {
    // need a key -> freq map
    // need a freq -> all keys map
    // need a key -> val map
    // need a variable to keep the min freq
    /* when getting a key
    - if not exist, return -1
    - increase freq in the map
    - move the key to freq + 1 list/linked hash set (delete from orig and add to new)
    - update minFreq if needed
    - return the val
    */
    /** putting a key
    - if not exist, add to key -> val map
    - increase freq in the map
    - move the key from freq to freq + 1 set (if already exist)
    - if over capacity:
        - get the least freq used 
        - if set size > 1, remove the first one
    */
    private int capacity;
    private Map<Integer, Integer> keyValMap;
    private Map<Integer, LinkedHashSet<Integer>> freqKeyMap;
    private Map<Integer, Integer> keyFreqMap;
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyValMap = new HashMap<>();
        freqKeyMap = new HashMap<>();
        keyFreqMap = new HashMap<>();
        this.minFreq = 0;
    }

    private void increaseFreq(int key) {
        int freq = this.keyFreqMap.get(key);
        this.keyFreqMap.put(key, freq + 1);

        Set<Integer> keys = this.freqKeyMap.get(freq);
        keys.remove(key);
        if (keys.size() == 0) {
            freqKeyMap.remove(freq);
            if (minFreq == freq) minFreq++;
        }
        LinkedHashSet<Integer> plusOne = freqKeyMap.getOrDefault(freq + 1, new LinkedHashSet<>());
        plusOne.add(key);
        freqKeyMap.put(freq + 1, plusOne);
        // freqKeyMap.putIfAbsent(freq + 1, new LinkedHashSet<>());
        // freqKeyMap.get(freq + 1).add(key);
    }
    
    public int get(int key) {
        if (!this.keyValMap.containsKey(key)) return -1;
        // increase frequency
        this.increaseFreq(key);
        // return value
        return this.keyValMap.get(key);
    }

    private void removeMinFreq() {
        Set<Integer> minFreqSet = this.freqKeyMap.get(minFreq);
        int deletedKey = minFreqSet.iterator().next();
        minFreqSet.remove(deletedKey);
        if (this.freqKeyMap.get(minFreq).size() == 0) {
            this.freqKeyMap.remove(minFreq);
        } 
        this.keyValMap.remove(deletedKey);
        this.keyFreqMap.remove(deletedKey);
    }
    
    public void put(int key, int value) {
        if (this.capacity <= 0) return; // need this line
        // if key exists
        // update key
        // increase freq
        if (this.keyValMap.containsKey(key)) {
            this.keyValMap.put(key, value);
            this.increaseFreq(key);
            return;
        }

        // if key doesn't exist
        // insert key value
        // insert freq
        // update minFreq
        // check capacity
        // if over cap, remove minFreq -> least recently used
        // update freq to keys
        if (this.keyValMap.size() >= this.capacity) {
            removeMinFreq();
        }
        this.keyValMap.put(key, value);
        this.keyFreqMap.put(key, 1);
        freqKeyMap.putIfAbsent(1, new LinkedHashSet<>());
        freqKeyMap.get(1).add(key);
        LinkedHashSet<Integer> set = this.freqKeyMap.getOrDefault(1, new LinkedHashSet<>());
        set.add(key);
        this.freqKeyMap.put(1, set);
        // freqKeyMap.putIfAbsent(1, new LinkedHashSet<>());
        // freqKeyMap.get(1).add(key);
        this.minFreq = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

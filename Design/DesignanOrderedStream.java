class OrderedStream {
    private Item[] items;
    private boolean[] printed;
    private int n;
    private int pointer;
    
    public OrderedStream(int n) {
        this.pointer = 0;
        this.n = n;
        this.items = new Item[n];
        this.printed = new boolean[n];
    }
    
    public List<String> insert(int idKey, String value) {
        Item item = new Item(idKey - 1, value);
        items[idKey - 1] = item;
        List<String> result = new ArrayList<>();
        while (pointer < n && items[pointer] != null) {
            result.add(items[pointer].value);
            pointer++;
        }
        return result;
    }
    
    class Item {
        public int idKey;
        public String value;
        
        public Item(int idKey, String value) {
            this.idKey = idKey;
            this.value = value;
        }
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */

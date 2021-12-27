class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (!curr.containsKey(word.charAt(i))) {
                curr.put(word.chxarAt(i), new TrieNode());
            }
            curr = curr.get(word.charAt(i));
        }
        curr.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (!curr.containsKey(word.charAt(i))) {
                return false;
            }
            curr = curr.get(word.charAt(i));
        }
        return curr.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!curr.containsKey(prefix.charAt(i))) {
                return false;
            }
            curr = curr.get(prefix.charAt(i));
        }
        return true;
    }
}


class TrieNode {
    private TrieNode[] links;
    
    private final int R = 26;
    
    private boolean isEnd;
    
    public TrieNode() {
        links = new TrieNode[R];
    }
    
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }
    
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }
    
    public void setEnd() {
        isEnd = true;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

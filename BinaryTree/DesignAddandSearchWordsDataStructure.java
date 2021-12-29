class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (!curr.containsKey(word.charAt(i))) {
                curr.put(word.charAt(i));
            }
            curr = curr.get(word.charAt(i));
        }
        curr.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode curr = this.root;
        return dfs(0, curr, word);
    }
    
    public boolean dfs(int start, TrieNode curr, String word) {
        for (int i = start; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                TrieNode[] children = curr.getChildren();
                for (int j = 0; j < children.length; j++) {
                    if (children[j] != null) {
                        if (dfs(i + 1, children[j], word)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            else {
                if (!curr.containsKey(ch)) {
                    return false;
                }
                curr = curr.get(ch);
            }         
        }
        return curr.getEnd();
    }
}

class TrieNode {
    private TrieNode[] children;
    
    private final int R = 26;
    
    private boolean isEnd = false;
    
    public TrieNode() {
        this.children = new TrieNode[R];
    }
    
    public void setEnd() {
        this.isEnd = true;
    }
    
    public boolean getEnd() {
        return this.isEnd;
    }
    
    public TrieNode[] getChildren() {
        return this.children;
    }
    
    public void put(char ch) {
        this.children[ch - 'a'] = new TrieNode();
    }
    
    public TrieNode get(char ch) {
        return this.children[ch - 'a'];
    }
    
    public boolean containsKey(char ch) {
        return this.children[ch - 'a'] != null;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

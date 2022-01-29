class Trie {
    public TrieNode root;

    public Trie() {
        this.root = new TrieNode(' ', false);
    }
    
    public void insert(String word) {
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode[] children = curr.children;
            char letter = word.charAt(i);
            if (children[letter - 'a'] != null) {
                curr = children[letter - 'a'];
                if (i == word.length() - 1) {
                    children[letter - 'a'].isEnd = true;
                }
            } else {
                for (int j = i; j < word.length(); j++) {
                    boolean isEnd;
                    letter = word.charAt(j);
                    if (j == word.length() - 1) {
                        isEnd = true;
                    } else {
                        isEnd = false;
                    }
                    curr.children[letter - 'a'] = new TrieNode(letter, isEnd);
                    curr = curr.children[letter - 'a'];
                }
                break;
            }
        }
    }
    
    public boolean search(String word) {
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode[] children = curr.children;
            char letter = word.charAt(i);
            if (children[letter - 'a'] == null) return false;
            curr = children[letter - 'a'];
        }
        if (curr.isEnd) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode[] children = curr.children;
            char letter = prefix.charAt(i);
            if (children[letter - 'a'] == null) return false;
            curr = children[letter - 'a'];
        }
        return true;
    }
}

class TrieNode {
    public char val;
    public boolean isEnd;
    public TrieNode[] children;
    
    public TrieNode(char val, boolean isEnd) {
        this.children = new TrieNode[26];
        this.val = val;
        this.isEnd = isEnd;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

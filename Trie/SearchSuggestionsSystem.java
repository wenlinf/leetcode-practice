class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        
        for (String product : products) {
            trie.insertWord(product);
        }
        List<List<String>> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : searchWord.toCharArray()) {
            sb.append(ch);
            List<String> words = trie.getWordsWithPrefix(sb.toString());
            result.add(words); 
        }
        return result;
    }
}

class Trie {
    private TrieNode root;
    private TrieNode curr; 
    private List<String> resultBuffer;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insertWord(String product) {
        curr = this.root;
        for (char ch : product.toCharArray()) {
            if (!curr.hasChild(ch)) {
                curr.addChild(ch);
            }
            curr = curr.getChild(ch);
        }
        curr.setEnd();
    }
    
    public List<String> getWordsWithPrefix(String prefix) {
        this.resultBuffer = new ArrayList<>();
        curr = this.root;
        
        for (char ch : prefix.toCharArray()) {  
            curr = curr.getChild(ch);
            if (curr == null) return resultBuffer;
        }
        dfsWithPrefix(curr, prefix);
        return resultBuffer;
    }
    
    private void dfsWithPrefix(TrieNode curr, String prefix) {
        if (resultBuffer.size() == 3) return;
        if (curr.getEnd()) {
            resultBuffer.add(prefix);
        }
        for (int i = 0; i < 26; i++) {
            TrieNode[] children = curr.getChildren();
            if (children[i] != null) {
                dfsWithPrefix(children[i], prefix + (char)('a' + i));
            }
        }
    }  
}

class TrieNode {
    private TrieNode[] children = new TrieNode[26];
    private boolean isEnd = false;
    
    public TrieNode() {
        
    } 

    public void setEnd() {
        this.isEnd = true;
    }
    
    public boolean getEnd() {
        return this.isEnd;
    }
    
    public void addChild(char ch) {
        this.children[ch - 'a'] = new TrieNode();
    }
    
    public TrieNode[] getChildren() {
        return this.children;
    }
    
    public boolean hasChild(char ch) {
        return this.children[ch - 'a'] != null;
    }
    
    public TrieNode getChild(char ch) {
        return this.children[ch - 'a'];
    }
}

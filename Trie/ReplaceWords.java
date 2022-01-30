class Solution {    
    public String replaceWords(List<String> dictionary, String sentence) {
        // build trie
        TrieNode root = new TrieNode(' ', false);
        TrieNode curr = root;
        for (String word: dictionary) {
            curr = root;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (!curr.hasChild(letter)) {
                    if (i == word.length() - 1) {
                        curr.children[letter - 'a'] = new TrieNode(letter, true);
                    } else {
                        curr.children[letter - 'a'] = new TrieNode(letter, false);
                    }                
                } else {
                  if (i == word.length() - 1) {
                    curr.children[letter - 'a'].isEnd = true;
                  }
                }
                curr = curr.children[letter - 'a'];
            }
        }
        // traverse sentence
        String[] words = sentence.split(" ");
        for (int j = 0; j < words.length; j++) {
            curr = root;
            String word = words[j];
            outerloop:
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (curr.hasChild(letter)) {
                    if (curr.children[letter - 'a'].isEnd) {
                        words[j] = word.substring(0, i + 1);
                        break outerloop;
                    }
                    curr = curr.children[letter - 'a'];
                } else {
                    break outerloop;
                }
            }
        }
        String result = String.join(" ", words);
        return result;
    }
}

class TrieNode {
    public TrieNode[] children;
    public char val;
    public boolean isEnd;
    
    public TrieNode(char val, boolean isEnd) {
        this.val = val;
        this.isEnd = isEnd;
        children = new TrieNode[26];
    }
    
    public boolean hasChild(char letter) {
        return this.children[letter - 'a'] != null;
    }
}

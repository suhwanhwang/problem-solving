class WordDictionary {
    static class TrieNode {
        boolean isEnd;
        TrieNode[] child = new TrieNode[26];
    }
    
    private TrieNode root = new TrieNode();
    
    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.child[index] == null) {
                cur.child[index] = new TrieNode();
            }
            cur = cur.child[index];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        return search(root, word);
    }
     
    public boolean search(TrieNode node, String word) {
        TrieNode cur = node;
        
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (c == '.') {
                for (int j = 0; j < cur.child.length; ++j) {
                    if (cur.child[j] != null && search(cur.child[j], word.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            } else if (cur.child[c - 'a'] == null) {
                return false;
            }
            cur = cur.child[c - 'a'];
        }
        return cur.isEnd;     
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

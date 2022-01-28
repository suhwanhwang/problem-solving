class WordDictionary {
    static class TrieNode {
        boolean isEnd;
        TrieNode[] child = new TrieNode[27];
    }
    
    private TrieNode root = new TrieNode();
    
    private static final int DOT = 26;

    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        addWord(root, word, 0);
    }
    
    private void addWord(TrieNode cur, String word, int index) {
        if (index >= word.length()) {
            cur.isEnd = true;
            return;
        }
        
        char c = word.charAt(index);
        if (cur.child[c - 'a'] == null) {
            cur.child[c - 'a'] = new TrieNode();
        }
        if (cur.child[DOT] == null) {
            cur.child[DOT] = new TrieNode();
        }
        addWord(cur.child[c - 'a'], word, index + 1);
        addWord(cur.child[DOT], word, index + 1);
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        
        for (char c : word.toCharArray()) {
            int index = (c == '.' ? DOT : c - 'a');
            if (cur.child[index] == null) {
                return false;
            }
            cur = cur.child[index];
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

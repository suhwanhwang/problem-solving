class StreamChecker {
    private String[] words;
    private StringBuilder sb = new StringBuilder();
    private int maxLen;

    public StreamChecker(String[] words) {
        this.words = words;
        for(String s : words) {
            maxLen = Math.max(maxLen, s.length());
            addNode(root, new StringBuilder(s).reverse().toString());
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        
        if(sb.length()>maxLen) {
            sb.deleteCharAt(0);
        }

        String current = new StringBuilder(sb).reverse().toString();
        //System.out.println(current + " " +isStart(root, current) );
        return isStart(root, current);
    }
    
    static class Trie {
        boolean isEnd = false;
        Trie[] child = new Trie[26];
    }
    
    private Trie root = new Trie();
    private void addNode(Trie root, String s) {
        Trie cur = root;
        for(char c : s.toCharArray()) {
            int index = c - 'a';
            if (cur.child[index] == null) {
                cur.child[index] = new Trie();
            }
            cur = cur.child[index];
        }
        cur.isEnd = true;
    }
    
    private boolean isStart(Trie root, String s) {
        Trie cur = root;
        for(char c : s.toCharArray()) {
            int index = c - 'a';
            if (cur.child[index] == null) {
                return false;
            }
            if (cur.child[index].isEnd) {
                return true;
            }
            cur = cur.child[index];
        }
        return cur.isEnd;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */

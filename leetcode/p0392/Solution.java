class Solution {
/*
    private static class Trie {
        Trie[] child = new Trie[26];
        //boolean isEnd = false;
    }
    
    private void addString(Trie root, String s) {        
        Trie cur = root;
        for (char c : s.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new Trie();
            }
        
            cur = cur.child[c - 'a'];
        }
        //cur.isEnd = true;
    }
    
    private boolean search(Trie root, String s) {        
        Trie cur = root;
        for (char c : s.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                return false;
            }
        
            cur = cur.child[c - 'a'];
        }
        return true;
    }

    
    public boolean isSubsequence(String s, String t) {
        Trie root = new Trie();
        
        for (int i = 0; i < t.length(); ++i) {
            addString(root, t.substring(i));
        }
        
        return search(root, s);
    }
*/
    public boolean isSubsequence(String s, String t) {
        int tIndex = -1;
        
        for (char c : s.toCharArray()) {
            tIndex = getIndex(t, tIndex + 1, c);
            if (tIndex == -1) {
                return false;
            }
        }
        return true;
    }

    private int getIndex(String s, int index, char c) {
        for(int i = index; i < s.length(); ++i) {
            if (s.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }
}

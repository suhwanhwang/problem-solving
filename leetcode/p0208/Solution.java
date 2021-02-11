/*
https://leetcode.com/problems/implement-trie-prefix-tree/description/

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

*/
class Trie {

    /** Initialize your data structure here. */
    private static final int MAX_CHILD = 26;
    static class Node {
        Node[] child = new Node[MAX_CHILD];
        boolean isEnd;
    }
    private Node root = new Node();
    public Trie() {
        
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        
        for(int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (cur.child[index] == null) {
                cur.child[index] = new Node();
            }
            cur = cur.child[index];
        }
        
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        
        for(int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (cur.child[index] == null) {
                return false;
            }
            cur = cur.child[index];
        }
        return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        
        for(int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            if (cur.child[index] == null) {
                return false;
            }
            cur = cur.child[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

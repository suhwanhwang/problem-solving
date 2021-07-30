/*
https://leetcode.com/problems/map-sum-pairs/

*/
class MapSum {

    /** Initialize your data structure here. */
    private final Map<String, Integer> map = new HashMap<>();
    private TrieNode root = new TrieNode();
    public MapSum() {
        
    }
    
    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        map.put(key, val);
        
        TrieNode cur = root;
        for (char c : key.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new TrieNode();
            }
            cur.child[c - 'a'].sum += diff;
            cur = cur.child[c - 'a'];
        }
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                return 0;
            }
            cur = cur.child[c - 'a'];
        }
        return cur.sum;
    }
    
    private static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

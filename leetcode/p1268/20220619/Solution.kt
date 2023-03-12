class Solution {
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        val root = TrieNode()
        for (p in products) {
            insert(root, p)
        }
        
        val ans = search(root, searchWord)
        return ans
    }
    
    class TrieNode(val child: Array<TrieNode?> = Array<TrieNode?>(26) { null }, val wordSet: MutableSet<String> = TreeSet<String>())
    
    private fun insert(root: TrieNode, s: String) {
        var cur = root
        for (c in s) {
            var node = cur.child[c - 'a']
            if (node == null) {
                node = TrieNode()
                cur.child[c - 'a'] = node
            }
            cur = node
            cur.wordSet.add(s)
        }
    }
    private fun search(root: TrieNode, s: String): List<List<String>>{
        val ans = mutableListOf<List<String>>()
        var cur = root
        for (c in s) {
            var node = cur.child[c - 'a']
            if (node == null) {
                node = TrieNode()
            } 
            cur = node
            ans.add(ArrayList(cur.wordSet.filterIndexed {i, e -> i < 3 }))
        }
        return ans
    }
}

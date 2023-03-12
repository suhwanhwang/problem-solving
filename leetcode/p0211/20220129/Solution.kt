class TrieNode(var isEnd: Boolean = false, val child: MutableMap<Char, TrieNode> = mutableMapOf())

class WordDictionary() {
    private val root = TrieNode()
    fun addWord(word: String) {
        var cur: TrieNode = root
        for (c in word.toCharArray()) {
            var next = cur.child[c]
            if (next == null) {
                next = TrieNode()
                cur.child[c] = next
            }
            cur = next
        }
        cur.isEnd = true
    }

    fun search(word: String): Boolean {
        return search(root, word)
    }

    private fun search(node: TrieNode, word: String): Boolean {
        var cur: TrieNode = node
        for (i in 0 until word.length) {
            if (word[i] == '.') {
                for (child in cur.child) {
                    if (search(child.value, word.substring(i + 1))) {
                        return true
                    }
                }
                return false
            } else {
                var next = cur.child[word[i]]
                if (next == null) {
                    return false
                }
                cur = next
            }
        }
        return cur.isEnd
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */

/*
class WordDictionary() {
    private val set = mutableSetOf<String>()
    
    fun addWord(word: String) {
        set.add(word)
        
        val chars = word.toCharArray()
        for (i in 0 until chars.size) {
            val temp = chars[i]
            chars[i] = '.'
            set.add(String(chars))
            chars[i] = temp
        }
    }

    fun search(word: String): Boolean {
        return set.contains(word)
    }

}
*/

class TrieNode(var isEnd:Boolean = false, val child:Array<TrieNode?> = Array<TrieNode?>(26) {null})

class WordDictionary() {
    private val root = TrieNode()
    fun addWord(word: String) {
        var cur:TrieNode = root
        val chars = word.toCharArray()
        for (c in word.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = TrieNode()
            }
            cur = cur.child[c - 'a']!!
        }
        cur.isEnd = true
    }

    fun search(word: String): Boolean {
        return search(root, word)
    }
    
    private fun search(node:TrieNode, word: String): Boolean {
        var cur:TrieNode = node
        for (i in 0 until word.length) {
            if (word[i] == '.') {
                for (j in 0 until cur.child.size) {
                    if (cur.child[j] != null && search(cur.child[j]!!, word.substring(i + 1))) {
                        return true
                    }
                }
                return false
            } else if (cur.child[word[i] - 'a'] == null) {
                return false
            }
            cur = cur.child[word[i] - 'a']!!
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

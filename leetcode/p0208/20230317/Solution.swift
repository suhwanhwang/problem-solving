class Trie {
    private class TrieNode {
        var child: [Character:TrieNode] = [:]
        var isEnd = false
    }
    
    private let root = TrieNode()

    init() {
        
    }
    
    func insert(_ word: String) {
        var node = root

        for c in word {
            if let nextNode = node.child[c] {
                node = nextNode
            } else {
                let newNode = TrieNode()
                node.child[c] = newNode
                node = newNode
            }
        }
        node.isEnd = true

        print(root.child)
    }
    
    func search(_ word: String) -> Bool {
        var node = root

        for c in word {
            if let nextNode = node.child[c] {
                node = nextNode
            } else {
                return false
            }
        }
        return node.isEnd
    }
    
    func startsWith(_ prefix: String) -> Bool {
        var node = root

        for c in prefix {
            if let nextNode = node.child[c] {
                node = nextNode
            } else {
                return false
            }
        }
        return true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * let obj = Trie()
 * obj.insert(word)
 * let ret_2: Bool = obj.search(word)
 * let ret_3: Bool = obj.startsWith(prefix)
 */

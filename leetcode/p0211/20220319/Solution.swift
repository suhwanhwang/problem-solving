class WordDictionary {
    class TrieNode {
        var child: [Character:TrieNode] = [:]
        var isEnd = false
    }

    private let root = TrieNode()

    init() {
        
    }
    
    func addWord(_ word: String) {
        var cur = root

        for c in word {
            if let node = cur.child[c] {
                cur = node
            } else {
                let newNode = TrieNode()
                cur.child[c] = newNode
                cur = newNode
            }
        }
        cur.isEnd = true;
    }
    
    func search(_ word: String) -> Bool {
        return search(Array(word), 0, root)
    }

    private func search(_ chars: [Character], _ index: Int, _ node: TrieNode) -> Bool {
        var cur = node
        
        for i in index..<chars.count {
            let c = chars[i]
            if c == "." {
                for (key, node) in cur.child {
                    if (search(chars, i + 1, node)) {
                        return true
                    }
                }
                return false 
            } else if let node = cur.child[c] {
                cur = node
            } else {
                return false
            }
        }
        return cur.isEnd
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * let obj = WordDictionary()
 * obj.addWord(word)
 * let ret_2: Bool = obj.search(word)
 */

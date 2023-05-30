class MyHashSet {
    //private var mySet: Set<Int> = []
    private var mySet = Array(repeating: false, count: 1000000 + 1)
    init() {
        
    }
    
    func add(_ key: Int) {
        //mySet.insert(key)
        mySet[key] = true
    }
    
    func remove(_ key: Int) {
        //mySet.remove(key)
        mySet[key] = false
    }
    
    func contains(_ key: Int) -> Bool {
        // return mySet.contains(key)
        return mySet[key]
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * let obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * let ret_3: Bool = obj.contains(key)
 */

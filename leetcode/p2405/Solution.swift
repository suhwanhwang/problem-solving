class Solution {
    func partitionString(_ s: String) -> Int {
        var set = Set<Character>()
        var count = 0
        for c in s {
            if set.contains(c) {
                count += 1
                set.removeAll()
            } 
            set.insert(c)
        }
        count += 1
        return count
    }
}

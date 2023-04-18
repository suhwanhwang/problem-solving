class Solution {
    func mergeAlternately(_ word1: String, _ word2: String) -> String {
        let len = max(word1.count, word2.count)
        let chars1 = Array(word1)
        let chars2 = Array(word2)
        var merged = String()
        for i in 0..<len {
            if i < chars1.count {
                merged.append(chars1[i])
            }
            if i < chars2.count {
                merged.append(chars2[i])
            }
        }
        return merged
    }
}

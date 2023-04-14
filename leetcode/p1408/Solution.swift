class Solution {
    func stringMatching(_ words: [String]) -> [String] {
        let sorted = words.sorted { $0.count < $1.count }
        print(sorted)

        var ans = [String]()
        for i in 0..<(sorted.count - 1) {
            var a = Array(sorted[i])
            for j in (i + 1)..<sorted.count {
                var b = Array(sorted[j])
                if (isSubstring(b, a)) {
                    ans.append(sorted[i])
                    break
                }
            }
        }
        return ans
    }

    private func isSubstring(_ a: [Character], _ b: [Character]) -> Bool {
        for i in 0..<(a.count - b.count + 1) {
            var isOk = true
            for j in 0..<b.count {
                if a[i + j] == b[j] {
                    continue
                } else {
                    isOk = false
                    break
                }
            }    
            if isOk {
                return true
            }
        }
        return false
    }
}

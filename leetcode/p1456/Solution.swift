class Solution {
    func maxVowels(_ s: String, _ k: Int) -> Int {
        let chars = Array(s)
        var left = 0
        var right = 0
        var maxV = 0
        var vowelCount = 0
        while right < chars.count {
            while left < chars.count && right - left + 1 > k {
                 if isVowel(chars[left]) {
                     vowelCount -= 1
                 }
                 left += 1
            }
            if isVowel(chars[right]) {
                vowelCount += 1
                maxV = max(maxV, vowelCount)
            }
            right += 1
        }

        return maxV
    }
    private func isVowel(_ c: Character) -> Bool {
        return c == "a" 
        || c == "e" 
        || c == "i"
        || c == "o"
        || c == "u"
        ? true : false
    }
}

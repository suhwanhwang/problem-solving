class Solution {
    func addDigits(_ num: Int) -> Int {
        var cur = num
        while cur >= 10 {
            var sum = 0
            while cur > 0 {
                sum += cur % 10
                cur /= 10
            }
            cur = sum
        }
        return cur
    }
}

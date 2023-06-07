class Solution {
    func minFlips(_ a: Int, _ b: Int, _ c: Int) -> Int {
        
        var a = a
        var b = b
        var c = c
        var count = 0
        while c != 0 || a != 0 || b != 0 {
            let curA = a & 0x1
            let curB = b & 0x1
            if (c & 0x1) == 0 {
                count += curA + curB
            } else {
                count += (curA == 0 && curB == 0 ? 1 : 0)
            }
            a >>= 1
            b >>= 1
            c >>= 1
        }
        return count
    }
}

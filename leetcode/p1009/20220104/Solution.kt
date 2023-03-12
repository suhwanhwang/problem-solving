class Solution {
    fun bitwiseComplement(n: Int): Int {
        var num = 1
        while (num < n) {
            num = (num shl 1) + 1
        }
        return num - n;
    }
}

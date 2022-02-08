class Solution {
    fun addDigits(num: Int): Int {
        if (num < 10)
            return num
        return addDigits(num.toString().map { it - '0' }.sum())
    }
}

class Solution {
    fun numSteps(s: String): Int {
        if (s.length == 1) return 0
        
        if (s[s.length - 1] == '1') {
            return 1 + numSteps(add1(s))
        } else {
            return 1 + numSteps(s.substring(0, s.length - 1))
        }
    }

    private fun add1(s: String): String {
        var num = StringBuilder()
        var carry = 1
        var i = s.length - 1
        while (i >= 0 || carry != 0) {
            val cur = if(i < 0) 0 else s[i] - '0'
            val remain = (cur + carry) % 2
            carry = (cur + carry) / 2
            num.insert(0, remain)
            i--
        }
        return num.toString()
    }
}

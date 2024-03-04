class Solution {
    fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
        
        tokens.sort()
        var left = 0
        var right = tokens.size - 1
        var score = 0
        var p = power
        while(left <= right) {
            if (p >= tokens[left]) {
                p -= tokens[left]
                score++
                left++
            } else if (left < right && score > 0 && p < tokens[right]) {
                score--
                p += tokens[right]
                right--
            } else {
                return score
            }
        }
        
        return score
    }
}

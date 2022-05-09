class Solution {
    val dial = arrayOf<String>("", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz")
    val combinations = mutableListOf<String>()
    
    fun letterCombinations(digits: String): List<String> {
        if (digits.length == 0) return listOf<String>()
        solve(digits, 0, StringBuilder())
        return combinations
    }
    
    fun solve(digits: String, index: Int, sb: StringBuilder) {
        if (index >= digits.length) {
            combinations.add(sb.toString())
            return
        }
        val num = digits[index] - '0'
        for (c in dial[num]) {
            sb.append(c)
            solve(digits, index+1, sb)
            sb.deleteCharAt(sb.length - 1)
        }
    }
}

class Solution {
    fun halvesAreAlike(s: String): Boolean {
        return (s.substring(0, s.length/2).filter { isVowel(it) }.length 
            == s.substring(s.length/2, s.length).filter { isVowel(it) }.length)
    }
    
    private fun isVowel(c: Char): Boolean {
        return when(c) {
            'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true
            else -> false
        }
    }
}

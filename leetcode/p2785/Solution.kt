class Solution {
    fun sortVowels(s: String): String {
        val vowels = mutableListOf<Char>()
        
        for (c in s) {
            when (c) {
                'a','e','i','o','u',
                'A','E','I','O','U' -> vowels.add(c)
            }
        }
        vowels.sort()
        val sb = StringBuilder()
        var index = 0
        for (c in s) {
            when (c) {
                'a','e','i','o','u',
'A','E','I','O','U' -> {
                    sb.append(vowels[index++])
                } else -> sb.append(c)
            }
        }
        return sb.toString()
    }
}

/*
https://leetcode.com/problems/number-of-matching-subsequences/

Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:

Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
Example 2:

Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2
 

Constraints:

1 <= s.length <= 5 * 10^4
1 <= words.length <= 5000
1 <= words[i].length <= 50
s and words[i] consist of only lowercase English letters.

*/

class Solution {
    private Map<String, Boolean> map;
    public int numMatchingSubseq(String s, String[] words) {
    
        int count = 0;
        map = new HashMap<>();
        
        for (int i = 0; i < words.length; ++i) {
            if (isMatched(s, words[i])) {
                count++;
            }
        }
        return count;
    }
    
    /*
    s = "abcde", words = ["a","bb","acd","ace"]
            ^                         ^
    */
    private boolean isMatched(String s, String w) {
        if (map.containsKey(w)) {
            return map.get(w);
        }
        
        for (int i = 0, j = 0; i < w.length(); ++i, ++j) {
            while (j < s.length() && s.charAt(j) != w.charAt(i)) {
                j++;
            }
            if (j >= s.length()) {
                map.put(w, false);
                return false;
            }
        }
        map.put(w, true);
        return true;
    }
}

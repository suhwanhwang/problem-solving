/*
https://leetcode.com/problems/verifying-an-alien-dictionary/

In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
*/
class Solution {
    private Map<Character, Integer> map = new HashMap<>();
        
    public boolean isAlienSorted(String[] words, String order) {
        String[] sorted = Arrays.copyOf(words, words.length);
        for (int i = 0; i < order.length(); ++i) {
            map.put(order.charAt(i), i);
        }
        
        Arrays.sort(sorted, (s1, s2) -> {
            for (int i = 0; i < s1.length(); ++i) {
                int diff = map.get(s1.charAt(i)) - (s2.length() > i ? map.get(s2.charAt(i)) : -1);
                if (diff == 0) {
                    continue;
                }
                return diff;
            }
            return s1.length() - s2.length();
        });
        
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(sorted[i])) {
                continue;
            }
            
            return false;
        }
        return true;
        
    }
}

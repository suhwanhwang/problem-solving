/*
https://leetcode.com/problems/valid-anagram/

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapS = getCharMap(s);
        Map<Character, Integer> mapT = getCharMap(t);
        
        if (mapS.size() != mapT.size()) {
            return false;
        }
        
        for (Map.Entry<Character, Integer> entry : mapS.entrySet()) {
            if (!entry.getValue().equals(mapT.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
    
    private Map<Character, Integer> getCharMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map;
    }
}

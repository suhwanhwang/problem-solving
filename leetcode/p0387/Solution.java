/*
https://leetcode.com/problems/first-unique-character-in-a-string/

Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
 

Note: You may assume the string contains only lowercase English letters.
*/
class Solution {
    public int firstUniqChar(String s) {
        int[] charMap = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            charMap[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s.length(); ++i) {
            if (charMap[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}

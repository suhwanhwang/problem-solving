/*
https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

 

Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 

Constraints:

1 <= s.length <= 10^4
s consists of only lowercase English letters.
1 <= k <= 10^5

*/
class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        int[] map;
        for (int i = 0; i <= s.length() - k; ++i) {
            map = new int[26];
        
            for (int j = i; j < s.length(); ++j) {
                map[s.charAt(j) - 'a']++;
                if (isLeastRepeatCharacters(map, k)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
    
    private boolean isLeastRepeatCharacters(int[] map, int k) {
        for (int i = 0; i < 26; ++i) {
            if (map[i] == 0) {
                continue;
            }
            if (map[i] < k) {
                return false;
            }
        }
        return true;
    }
}

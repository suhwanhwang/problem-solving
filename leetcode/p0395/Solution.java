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
        int maxKRepeatChar = getMaxKRepeatChar(s, k);
        int maxLen = 0;
        for (int i = 1; i <= maxKRepeatChar; ++i) {
            maxLen = Math.max(maxLen, getLongestKRepeatInNChar(s,k,i));
        }
        return maxLen;
    }
    
    private int getMaxKRepeatChar(String s, int k) {
        int count = 0;
        int[] map = new int[26];
        for(int i = 0; i < s.length(); ++i) {
            map[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < map.length; ++i) {
            if(map[i] >= k) {
                count++;
            }
        }
        return count;
    }
    
    private int getLongestKRepeatInNChar(String s, int k, int n) {
        int[] map = new int[26];
        Set<Integer> set = new HashSet<>();
        Set<Integer> kset = new HashSet<>();
        int start = 0;
        int maxLen = 0;
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            set.add(c - 'a');
            map[c - 'a']++;
            if (map[c - 'a'] == k) {
                kset.add(c - 'a');
            }
            
            while (set.size() > n) {
                int index = s.charAt(start) - 'a';
                map[index]--;
                if (map[index] == 0) {
                    set.remove(index);
                } else if (map[index] < k) {
                    kset.remove(index);
                }
                start++;
            }
            if (kset.size() == n) {
                maxLen = Math.max(maxLen, i - start + 1);
            }
        }
        return maxLen;
    }
    
}

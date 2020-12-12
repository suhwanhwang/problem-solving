/*
https://leetcode.com/problems/minimum-window-substring/description/
Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
*/

class Solution {
    public String minWindow(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tChar.length; ++i) {
            map.put(tChar[i], map.getOrDefault(tChar[i],0)+1);
        }
        
        String ans = "";
        int start = 0;
        int matchLen = 0;
        int maxLen = sChar.length + 1;
        for (int e = 0; e < sChar.length; ++e) {
            if (!map.containsKey(sChar[e])) {
                continue;
            }
            
            Integer count = map.get(sChar[e]);
            if (count > 0) {
                matchLen++;
            }
            map.put(sChar[e], count-1);
            
            while(matchLen == tChar.length) {
                if (map.containsKey(sChar[start])) {
                    count = map.get(sChar[start]);
                    if (count == 0) {
                        matchLen--;
                    }
                    
                    map.put(sChar[start], count+1);
                    if (maxLen > e - start + 1) {
                        maxLen = e - start + 1;
                        ans = s.substring(start, e + 1);
                    }
                }
                start++;
            }
            
        }
        return ans;
    }
}

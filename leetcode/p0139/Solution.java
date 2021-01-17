/*
https://leetcode.com/problems/word-break/description/

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/
class Solution {
    private boolean helper(String s, Set<String> wordSet, Map<String,Boolean> dp) {
         if (wordSet.contains(s)) {
            return true;
        }
        
        if (dp.containsKey(s)) {
            return dp.get(s);
        }
        
        for (int i = 1; i <= s.length(); ++i) {
            String sub = s.substring(0,i);
            if (wordSet.contains(sub) && helper(s.substring(i),wordSet, dp)) {
                dp.put(s, true);
                return true;
            }
        }
        dp.put(s, false);
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String,Boolean> dp = new HashMap<>();
        
        return helper(s, wordSet, dp);
    }
}

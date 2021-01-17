/*
https://leetcode.com/problems/word-break-ii/description/

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
*/
class Solution {
    Map<String, List<String>> dp = new HashMap<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        if (dp.containsKey(s)) {
            return dp.get(s);
        }
        
        List<String> sentences = new ArrayList<>();
        
        for (String word : wordDict) {
            if (s.equals(word)) {
                sentences.add(word);
            } else if (s.startsWith(word)) {
                for (String sentence : wordBreak(s.substring(word.length()), wordDict)) {
                    sentences.add(word + " " + sentence);
                }
            }          
        }
        dp.put(s, sentences);
        return sentences;
    }
}

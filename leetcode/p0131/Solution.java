/*
https://leetcode.com/problems/palindrome-partitioning/

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
*/
class Solution {
    List<List<String>> palindromes;
    
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    
    private void solve(String s, int index, List<String> p) {
        if (index == s.length()) {
            palindromes.add(new ArrayList(p));
            return;
        }
        
        for (int i = index + 1; i <= s.length(); ++i) {
            String sub = s.substring(index, i);
            if (isPalindrome(sub)) {
                p.add(sub);
                solve(s, i, p);
                p.remove(p.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        palindromes = new ArrayList<>();
        
        List<String> p = new ArrayList<>();
        solve(s, 0, p);
        return palindromes;
    }
}

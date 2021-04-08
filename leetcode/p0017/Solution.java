/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/
class Solution {
    private static final String[] dials = {
        "",
        "",    "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };
    private List<String> allList = new ArrayList<>();
        
    public List<String> letterCombinations(String digits) {
        helper(digits, 0, new StringBuilder());
        return allList;
    }
    
    private void helper(String digits, int index, StringBuilder output) {
        if (index >= digits.length()) {
            if (output.length() > 0) {
                allList.add(output.toString());
            }
            return;
        }
        String chars = dials[digits.charAt(index) - '0'];
        for (int i = 0; i < chars.length(); ++i) {
            output.append(chars.charAt(i));
            helper(digits, index + 1, output);
            output.deleteCharAt(output.length() - 1);
        }
    }
}

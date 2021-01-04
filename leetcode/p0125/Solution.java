/*
https://leetcode.com/problems/valid-palindrome/

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 

Constraints:

s consists only of printable ASCII characters.
*/
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right) {
            char leftChar = s.charAt(left);
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }
            
            char rightChar = s.charAt(right);
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }
            
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

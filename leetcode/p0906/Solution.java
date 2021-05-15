/*
https://leetcode.com/problems/super-palindromes/description/

Let's say a positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.

Given two positive integers left and right represented as strings, return the number of super-palindromes integers in the inclusive range [left, right].

 

Example 1:

Input: left = "4", right = "1000"
Output: 4
Explanation: 4, 9, 121, and 484 are superpalindromes.
Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
Example 2:

Input: left = "1", right = "2"
Output: 1
 

Constraints:

1 <= left.length, right.length <= 18
left and right consist of only digits.
left and right cannot have leading zeros.
left and right represent integers in the range [1, 10^18 - 1].
left is less than or equal to right.
*/
class Solution {
    public int superpalindromesInRange(String left, String right) {
        long leftNum = Long.parseLong(left);
        long rightNum = Long.parseLong(right);
        final long MAX = 100000;
        int count = 0;
        for (long i = 1; i < MAX; ++i) {
            String s = String.valueOf(i);
            StringBuilder sb = new StringBuilder(s);
            for (int j = s.length() - 2; j >= 0; --j) {
                sb.append(sb.charAt(j));
            }
            
            long p = Long.parseLong(sb.toString());
            long sq = p * p;
            
            if (sq < leftNum || sq > rightNum) {
                continue;
            }
            
            if (isPalindrome(sq)) {
                //System.out.println(p + " " + sq);
                count++;
            }
        }
        
        for (long i = 1; i < MAX; ++i) {
            String s = String.valueOf(i);
            StringBuilder sb = new StringBuilder(s);
            for (int j = s.length() - 1; j >= 0; --j) {
                sb.append(sb.charAt(j));
            }
            
            long p = Long.parseLong(sb.toString());
            long sq = p * p;
            
            if (sq < leftNum || sq > rightNum) {
                continue;
            }
            if (isPalindrome(sq)) {
                //System.out.println(p + " " + sq);
                count++;
            }
        }
        return count;
    }
    private boolean isPalindrome(long num) {
        String s = String.valueOf(num);
        
        for (int i = 0; i < s.length() / 2; ++i) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) {
                return false;
            } 
        }
        return true;
    }
}

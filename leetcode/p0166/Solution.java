/*
https://leetcode.com/problems/fraction-to-recurring-decimal/description/
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

 

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
Example 4:

Input: numerator = 4, denominator = 333
Output: "0.(012)"
Example 5:

Input: numerator = 1, denominator = 5
Output: "0.2"
 

Constraints:

-231 <= numerator, denominator <= 231 - 1
denominator != 0

*/

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        
        if (numerator == 0) {
            return "0";
        }
        long num = numerator;
        long den = denominator;
        if (num * den < 0) {
            sb.append("-");
            num *= (num < 0 ? -1:1);
            den *= (den < 0 ? -1:1);
        }
        long q = num / den;
        long r = num % den;
        sb.append(q);
        if (r == 0) {
            return sb.toString();
        }
        sb.append(".");
        
        Map<Long, Integer> map = new HashMap<>();
        
        while (r != 0) {
            map.put(r, sb.length());
            r *= 10;
            q = r / den;
            r %= den;
            
            if (map.containsKey(r)) {
                int index = map.get(r);
                sb.insert(index,"(");
                sb.append(q);
                sb.append(")");
                return sb.toString();
            }
            
            sb.append(q);
        }
        return sb.toString();
    }
}

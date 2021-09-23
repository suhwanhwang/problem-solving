// https://leetcode.com/problems/break-a-palindrome/
class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) {
            return "";
        }
        char[] chars = palindrome.toCharArray();
        boolean isOk = false;
        
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] != 'a' && !(chars.length % 2 == 1 && i == chars.length/2)) {
                chars[i] = 'a';
                isOk = true;
                break;
            }
        }
        if (isOk) {
            return new String(chars);
        }
        
        for (int i = chars.length-1; i >= 0; --i) {
            if (chars[i] != 'z') {
                chars[i]++;
                break;
            }
        }
        
        return new String(chars);
    }
}

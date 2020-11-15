/*
https://leetcode.com/problems/implement-strstr/

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? 
This is a great question to ask during an interview.

For the purpose of this problem, 
we will return 0 when needle is an empty string. 
This is consistent to C's strstr() and Java's indexOf().

*/

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length()==0) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
            
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            boolean isOk = true;
            for (int j = 1; j < needle.length(); ++j) {
                if (haystack.charAt(i+j)  == needle.charAt(j)) {
                    continue;
                }
                
                isOk = false;
                break;
            }
            if (isOk) {
                return i;
            }
        }
        return -1;
    }
}

/*
https://leetcode.com/problems/palindrome-pairs/

Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.

 

Example 1:

Input: words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]
Example 3:

Input: words = ["a",""]
Output: [[0,1],[1,0]]
 

Constraints:

1 <= words.length <= 5000
0 <= words[i].length <= 300
words[i] consists of lower-case English letters.
*/
class Solution {
    public List<List<Integer>> palindromePairs_bf(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < words.length - 1; ++i) {
            for (int j = i+1; j < words.length; ++j) {
                if (isPalindrome(words[i] + words[j])) {
                    ans.add(Arrays.asList(i,j));
                }
                if (isPalindrome(words[j] + words[i])) {
                    ans.add(Arrays.asList(j,i));
                }
            }
        }
        return ans;
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < words.length; ++i) {
            map.put(words[i], i);
        }
            
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals("")) {
                for (int j = 0; j < words.length; ++j) {
                    if (j != i && isPalindrome(words[j])) {
                        ans.add(Arrays.asList(i, j));
                        ans.add(Arrays.asList(j, i));
                    }
                }
                continue;
            }
            
            StringBuilder sb = new StringBuilder(words[i]);
            String reversed = sb.reverse().toString();
            int reversedIndex = map.getOrDefault(reversed, i);
            if (reversedIndex != i) {
                ans.add(Arrays.asList(i, reversedIndex));
            }
            
            // 0... j...(len-1)
            // abcde  edcba
            for (int j = 1; j < reversed.length(); ++j) {
                String front = reversed.substring(0, j);
                String back = reversed.substring(j);
                if (isPalindrome(front)) {
                    int index = map.getOrDefault(back, i);
                    if (index != i) {
                        ans.add(Arrays.asList(i, index));
                    }
                }
                
                if (isPalindrome(back)) {
                    int index = map.getOrDefault(front, i);
                    if (index != i) {
                        ans.add(Arrays.asList(index, i));
                    }
                }
            }
        }
        return ans;
    }
    
    private boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
